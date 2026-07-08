// vars/buildStage.groovy
def call(Map config = [:]) {
    stage('Build') {
        echo "Building ${config.appName ?: 'application'}..."
        sh "docker build -t ${config.imageName}:${env.BUILD_NUMBER} ."
    }
}
