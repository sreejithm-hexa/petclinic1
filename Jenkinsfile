@Library("Shared-Library") _

pipeline {
    agent any
    stages {
        stage('Checkout') {
            steps {
                script {
                    gitCheckout(
                branch: "main",
                url: "https://github.com/spring-projects/spring-petclinic.git"
                    )
                }
            }
        }
        stage('Build') {
            steps {
                script {
                    maven("compile")
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    maven("test")
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    maven("clean package")
                }
            }
        }
    }
}