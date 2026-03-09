# Script para iniciar e testar o Spring Boot

Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  UNIPDS Events - Spring Boot Starter" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Parar processos Java existentes
Write-Host "1. Parando processos Java anteriores..." -ForegroundColor Yellow
Get-Process java -ErrorAction SilentlyContinue | Stop-Process -Force -ErrorAction SilentlyContinue
Start-Sleep -Seconds 2

# Limpar porta 8080
Write-Host "2. Limpando porta 8080..." -ForegroundColor Yellow
$connections = Get-NetTCPConnection -LocalPort 8080 -ErrorAction SilentlyContinue
foreach ($conn in $connections) {
    Stop-Process -Id $conn.OwningProcess -Force -ErrorAction SilentlyContinue
}
Start-Sleep -Seconds 2

# Compilar projeto
Write-Host "3. Compilando projeto..." -ForegroundColor Yellow
$compileOutput = & .\mvnw.cmd clean compile 2>&1
if ($compileOutput -match "BUILD SUCCESS") {
    Write-Host "   ✅ Compilação bem-sucedida!" -ForegroundColor Green
} else {
    Write-Host "   ❌ Erro na compilação!" -ForegroundColor Red
    Write-Host $compileOutput
    exit 1
}

# Iniciar Spring Boot em background
Write-Host "4. Iniciando Spring Boot..." -ForegroundColor Yellow
$job = Start-Job -ScriptBlock {
    Set-Location $using:PWD
    & .\mvnw.cmd spring-boot:run 2>&1
}

# Aguardar inicialização
Write-Host "5. Aguardando inicialização (30 segundos)..." -ForegroundColor Yellow
$maxAttempts = 30
$attempt = 0
$started = $false

while ($attempt -lt $maxAttempts -and -not $started) {
    Start-Sleep -Seconds 1
    $attempt++

    # Testar se servidor respondeu
    try {
        $response = Invoke-WebRequest -Uri "http://localhost:8080/v3/api-docs" -UseBasicParsing -ErrorAction SilentlyContinue -TimeoutSec 2
        if ($response.StatusCode -eq 200) {
            $started = $true
            Write-Host "   ✅ Servidor iniciado com sucesso!" -ForegroundColor Green
        }
    } catch {
        # Ainda não iniciou, continuar aguardando
    }

    Write-Progress -Activity "Aguardando servidor iniciar" -Status "$attempt/$maxAttempts segundos" -PercentComplete (($attempt / $maxAttempts) * 100)
}

Write-Progress -Activity "Aguardando servidor iniciar" -Completed

if (-not $started) {
    Write-Host "   ⚠️  Timeout ao aguardar servidor" -ForegroundColor Yellow
    Write-Host "   Verifique os logs manualmente" -ForegroundColor Yellow
}

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  TESTANDO ENDPOINTS" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

# Testar endpoints
function Test-Endpoint {
    param(
        [string]$Name,
        [string]$Url
    )

    try {
        $response = Invoke-WebRequest -Uri $Url -UseBasicParsing -ErrorAction Stop -TimeoutSec 5
        if ($response.StatusCode -eq 200) {
            Write-Host "✅ $Name" -ForegroundColor Green
            Write-Host "   URL: $Url" -ForegroundColor Gray
            return $true
        }
    } catch {
        $statusCode = $_.Exception.Response.StatusCode.Value__
        if ($statusCode) {
            Write-Host "❌ $Name (Status: $statusCode)" -ForegroundColor Red
        } else {
            Write-Host "❌ $Name (Não respondeu)" -ForegroundColor Red
        }
        Write-Host "   URL: $Url" -ForegroundColor Gray
        return $false
    }
}

$swaggerOk = Test-Endpoint "Swagger UI" "http://localhost:8080/swagger-ui/index.html"
$apiDocsOk = Test-Endpoint "API Docs (JSON)" "http://localhost:8080/v3/api-docs"
$h2ConsoleOk = Test-Endpoint "H2 Console" "http://localhost:8080/h2-console"

Write-Host ""
Write-Host "========================================" -ForegroundColor Cyan
Write-Host "  URLs PARA ACESSO" -ForegroundColor Cyan
Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""

if ($swaggerOk) {
    Write-Host "📖 Swagger UI (Documentação Interativa):" -ForegroundColor Cyan
    Write-Host "   http://localhost:8080/swagger-ui/index.html" -ForegroundColor White
    Write-Host ""
}

if ($apiDocsOk) {
    Write-Host "📄 API Docs (OpenAPI JSON):" -ForegroundColor Cyan
    Write-Host "   http://localhost:8080/v3/api-docs" -ForegroundColor White
    Write-Host ""
}

if ($h2ConsoleOk) {
    Write-Host "🗄️  H2 Database Console:" -ForegroundColor Cyan
    Write-Host "   http://localhost:8080/h2-console" -ForegroundColor White
    Write-Host "   User: sa | Password: (vazio) | JDBC URL: jdbc:h2:mem:db_events" -ForegroundColor Gray
    Write-Host ""
}

Write-Host "========================================" -ForegroundColor Cyan
Write-Host ""
Write-Host "Servidor rodando em background (Job ID: $($job.Id))" -ForegroundColor Yellow
Write-Host "Para parar o servidor:" -ForegroundColor Yellow
Write-Host "  Stop-Job -Id $($job.Id); Remove-Job -Id $($job.Id)" -ForegroundColor Gray
Write-Host ""
Write-Host "Para ver os logs:" -ForegroundColor Yellow
Write-Host "  Receive-Job -Id $($job.Id)" -ForegroundColor Gray
Write-Host ""

