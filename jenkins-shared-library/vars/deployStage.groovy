// vars/deployStage.groovy
def call(Map config = [:]) {
    stage('Deploy') {
        echo "Deploying ${config.imageName}:${env.BUILD_NUMBER} to ${config.environment ?: 'staging'}..."
        withCredentials([usernamePassword(credentialsId: config.deployCredsId ?: 'deploy-creds',
                                           usernameVariable: 'DEPLOY_USER',
                                           passwordVariable: 'DEPLOY_PASS')]) {
            sh """
                docker tag ${config.imageName}:${env.BUILD_NUMBER} ${config.registry}/${config.imageName}:${env.BUILD_NUMBER}
                docker push ${config.registry}/${config.imageName}:${env.BUILD_NUMBER}
            """
        }
    }
}
