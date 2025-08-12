pipeline {
    agent any

    tools {
        maven 'Maven 3.8.7'  // Replace with the name you gave the Maven installation
    }

    stages {
        stage('Checkout') {
            steps {
                git 'https://github.com/amandeep88sng-gif/cw2-app.git'
            }
        }
        stage('Build') {
            steps {
                sh 'mvn clean install'
            }
        }
        stage('SonarQube Analysis') {
            steps {
                withSonarQubeEnv('sonarqube') {
                    sh 'sonar-scanner \
                      -Dsonar.projectKey=currency-ci \
                      -Dsonar.sources=. \
                      -Dsonar.host.url=http://13.41.66.166:9000 \
                      -Dsonar.login=sqp_f39d8ef1854532fce2f90b13451940cebe3b5ee9'
                }
            }
        }
        stage('Test') {
            steps {
                sh 'mvn test'
            }
        }
        stage('Deploy') {
            steps {
                sh 'kubectl apply -f deployment.yaml'
            }
        }
    }
}
