// vars/standardPipeline.groovy
// Central entry point - all onboarded apps call this from their Jenkinsfile
def call(Map config = [:]) {
    pipeline {
        agent any
        stages {
            stage('Checkout') {
                steps {
                    checkout scm
                }
            }
            stage('Build')  { steps { script { buildStage(config) } } }
            stage('Test')   { steps { script { testStage(config) } } }
            stage('Scan')   { steps { script { scanStage(config) } } }
            stage('Deploy') { steps { script { deployStage(config) } } }
        }
        post {
            always {
                echo "Pipeline finished for ${config.appName}"
            }
        }
    }
}
