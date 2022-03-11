pipeline {
    agent any

    stages {
        stage('Build') {
            steps {
                git 'https://github.com/linozthiago/petAdoptionCatalogue.git'
            }
        }
        stage('Test') {
            steps {
                sh 'mvn clean test'
            }
        }
    }
}