node {  
    stage('Build') { 
        //git 'https://github.com/SahilBafna/Petclinic.git'
        bat "mvn clean compile"
    }
    stage('Test') { 
        bat "mvn clean test"
    }
}