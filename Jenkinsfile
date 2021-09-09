node {  
    stage('Build') { 
        //git 'https://github.com/SahilBafna/Petclinic.git'
        sh "mvn clean compile"
    }
    stage('Test') { 
        sh "mvn clean test"
    }
}