// vars/scanStage.groovy
def call(Map config = [:]) {
    stage('Scan') {
        echo "Scanning image ${config.imageName}:${env.BUILD_NUMBER} for vulnerabilities..."
        sh "trivy image --severity HIGH,CRITICAL ${config.imageName}:${env.BUILD_NUMBER} || true"
    }
}
