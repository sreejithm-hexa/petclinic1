node {  
    stage('Build') { 
        git "https://github.com/SahilBafna/Petclinic.git"
        sh "/opt/apache-maven-3.6.3/bin/mvn clean compile"
    }
    stage('Test') { 
        sh "/opt/apache-maven-3.6.3/bin/mvn clean test"
    }
}