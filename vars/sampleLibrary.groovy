def sayHello(String name = 'World') {
    echo "Hello, ${name}!"
}

def buildApplication(String projectName) {
    echo "Building project: ${projectName}"
    sh "mvn clean install"
}