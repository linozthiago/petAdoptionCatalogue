pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git ''
                sh './mvnw clean compile'
            }
        }
    }
}