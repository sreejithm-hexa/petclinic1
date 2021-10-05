@Library("Shared-Library")_
import com.app.MavenUtil

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
                    utils.mvn 'compile'
                }
            }
        }
        stage('Test') {
            steps {
                script {
                    utils.mvn 'test'
                }
            }
        }
        stage('Package') {
            steps {
                script {
                    utils.mvn 'clean package'
                }
            }
        }
    }
}