// This file defines functions that can be called in Jenkinsfile
import com.example.SampleHelper2

def sayHello(String name) {
    echo "Hello, ${name}!"
}

def buildProject(String tool = 'maven') {
    echo "Starting build with ${tool}..."
    SampleHelper2.buildProject(tool)
}

def runTests(String tool = 'maven') {
    echo "Starting tests with ${tool}..."
    SampleHelper2.runTests(tool)
}

def deployToEnvironment(String environment) {
    echo "Deploying to ${environment}..."
    // Add deployment logic here
}

def notifySuccess(String channel = '#team') {
    SampleHelper2.notify('success', channel)
}

def notifyFailure(String channel = '#team') {
    SampleHelper2.notify('failure', channel)
}
