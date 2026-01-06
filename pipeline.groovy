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
               
             sh '''mvn clean verify sonar:sonar \\
  -Dsonar.projectKey=new-studentapp \\
  -Dsonar.host.url=http://18.119.103.150:9000 \\
  -Dsonar.login=cb3a8ed37f0d155447ddaec6db9516b9b05ea07f'''
            }
        }
        stage('Deploy') {
            steps {
                echo "deploy-sucess"
            }
        }
    }
}