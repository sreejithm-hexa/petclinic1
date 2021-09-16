node {  
    stage('Build') { 
        git "https://HexOne@dev.azure.com/HexOne/PV/_git/petclinic1.git"
        sh "/opt/apache-maven-3.6.3/bin/mvn  -f /var/lib/jenkins/workspace/PetClinic clean compile"
    }
    stage('Test') { 
        sh "/opt/apache-maven-3.6.3/bin/mvn -f /var/lib/jenkins/workspace/PetClinic clean test"
    }
}