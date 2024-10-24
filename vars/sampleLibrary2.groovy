// This file defines functions that can be called in Jenkinsfile

def sayHello(String name) {
    echo "Hello, ${name}!"
}

def buildProject() {
    // Logic for building the project
    echo "Building the project..."
    // Example: if it's a Maven project
    sh 'mvn clean install'
}

def runTests() {
    // Logic for running tests
    echo "Running tests..."
    // Example: if it's a Maven project
    sh 'mvn test'
}

def deployToEnvironment(String environment) {
    // Logic for deploying to a specific environment
    echo "Deploying to ${environment}..."
    if (environment == 'production') {
        sh 'echo Deploying to production...'
        // Add actual deployment commands here
    } else if (environment == 'sit') {
        sh 'echo Deploying to development...'
        // Add actual deployment commands here
    } else {
        error "Unknown environment: ${environment}"
    }
}

def notifySuccess() {
    // Notify the team or user about the success
    echo "Build and deployment succeeded!"
    // Example: send a message via email or Slack
    // slackSend(channel: '#team', message: "Build succeeded!")
}

def notifyFailure() {
    // Notify the team or user about the failure
    echo "Build and deployment failed!"
    // Example: send a message via email or Slack
    // slackSend(channel: '#team', message: "Build failed!")
}
