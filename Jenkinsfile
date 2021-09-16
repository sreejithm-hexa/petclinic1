node {  
    stage('Build') { 
       
        sh "/opt/apache-maven-3.6.3/bin/mvn -f /var/lib/jenkins/workspace/PetClinic@script clean compile"
    }
    stage('Test') { 
        sh "/opt/apache-maven-3.6.3/bin/mvn -f /var/lib/jenkins/workspace/PetClinic@script clean test"
    }
}