pipeline {
    environment {
        registry = "codjohn0/calculator-java"
        registryCredential = 'dockerhub'
        dockerImage=''
    }
    agent any

    tools {
        maven 'apache maven 3.6.3'
        jdk 'JDK 11'
    }

    stages {
        stage ('Clean') {
            steps {
                sh 'mvn clean'
            }
        }
        
        stage ('Build') {
            steps {
                sh 'mvn compile'
            }
        }
        
        stage ('Short Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTest test'
            }
        }

        stage ('Long Tests') {
            steps {
                sh 'mvn -Dtest=CalculatorTestThorough test'
            }
            post {
                success {
                    junit 'target/surefire-reports/**/*.xml'
                }
            }
        }

        stage ('Package') {
            steps {
                sh 'mvn package'
                archiveArtifacts artifacts: 'src/**/*.java'
                archiveArtifacts artifacts: 'target/*.jar'
            }
        }

        stage ('Building image') {
            steps {
                script {
                    dockerImage = docker.build registry + ":$BUILD_NUMBER"
                }
            }
        }

        stage ('Deploy Image') {
            steps {
                script {
                    docker.withRegistry('', registryCredential) {
                        dockerImage.push()
                    }
                }
            }
        }

        stage ('Remove unused docker image') {
            steps {
                sh "docker rmi $registry:$BUILD_NUMBER"
            }
        }
    }

    post {
        failure {
            mail to: 'cjohns365@gmail.com',
                 subject: 'Failed Pipeline: ${currentBuild.fullDisplayName}',
                 body: "Error occurred during Pipeline process: ${env.BUILD_URL}"
        }
    }
}
