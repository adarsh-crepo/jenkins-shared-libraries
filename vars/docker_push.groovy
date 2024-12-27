def call(String Project, String ImageTag, String dockerHubUser){
           echo "Pushing the image to DockerHub"
            withCredentials([usernamePassword(credentialsId: "dockerHubCred", passwordVariable: "dockerHubPass", usernameVariable: "dockerHubUser")]) {
    sh """
        echo ${env.dockerHubPass} | docker login -u ${env.dockerHubUser} --password-stdin
    """
             sh "docker image tag notes-app:latest ${env.dockerHubUser}/notes-app:latest"
             sh "docker push ${env.dockerHubUser}/notes-app:latest"
             }
}
