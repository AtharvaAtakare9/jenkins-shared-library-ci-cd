// vars/testStage.groovy
def call(Map config = [:]) {
    stage('Test') {
        echo "Running tests for ${config.appName ?: 'application'}..."
        sh config.testCommand ?: 'echo "no test command provided"'
        junit allowEmptyResults: true, testResults: config.testResultsPattern ?: '**/test-results/*.xml'
    }
}
