@Library("Shared-Library") _
/*node {  
   
    stage('Build') { 
        checkout([
  $class: 'GitSCM',
  branches: [[name: '*/1.0.0']],
  userRemoteConfigs: [[ url: 'https://HexOne@dev.azure.com/HexOne/PV/_git/petclinic1.git' ]]
])
       
        sh "/opt/apache-maven-3.6.3/bin/mvn  -f /var/lib/jenkins/workspace/PetClinic clean compile"
    }
    stage('Test') { 
        sh "/opt/apache-maven-3.6.3/bin/mvn -f /var/lib/jenkins/workspace/PetClinic clean test"
    }
}*/
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
    }
}