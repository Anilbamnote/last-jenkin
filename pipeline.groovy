pipeline {
    agent  {label 'node'}
    stages {
        stage('git_checkout') {
            steps {
               git branch: 'main', url: 'https://github.com/Anilbamnote/student-ui-app.git'
            }
        }
        stage('build-stage') {
            steps {
               
                sh '''/opt/maven/bin/mvn clean package'''
            }
        }
        stage('test-stage') {
            steps {
               
                echo "test-sucess" 
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy-sucess"
            }
        }
    }
}