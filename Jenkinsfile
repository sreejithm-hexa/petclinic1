node {  
    stage('Build') { 
       
        sh "/opt/maven/bin/mvn -f /var/lib/jenkins/workspace/PetClinic@script clean compile"
    }
    stage('Test') { 
        sh "/opt/maven/bin/mvn -f /var/lib/jenkins/workspace/PetClinic@script clean test"
    }
}