package com.example

class SampleHelper2 {

    static void runBuildCommand(String command) {
        if (isWindows()) {
            bat command  // Use bat on Windows
        } else {
            sh command   // Use sh on non-Windows (Linux/MacOS)
        }
    }

    static boolean isWindows() {
        return System.properties['os.name'].toLowerCase().contains('windows')
    }

    // Method for building the project
    static void buildProject(String buildTool) {
        if (buildTool == 'maven') {
            println "Building the project with Maven..."
            runBuildCommand('mvn clean install')
        } else if (buildTool == 'gradle') {
            println "Building the project with Gradle..."
            runBuildCommand('./gradlew build')
        } else {
            throw new IllegalArgumentException("Unknown build tool: ${buildTool}")
        }
    }

    // Method for running tests
    static void runTests(String testTool) {
        if (testTool == 'maven') {
            println "Running tests with Maven..."
            runBuildCommand('mvn test')
        } else if (testTool == 'gradle') {
            println "Running tests with Gradle..."
            runBuildCommand('./gradlew test')
        } else {
            throw new IllegalArgumentException("Unknown test tool: ${testTool}")
        }
    }

    // Method for notifying based on result
    static void notify(String status, String channel) {
        if (status == 'success') {
            println "Sending success notification to ${channel}"
            // Example: slackSend(channel: channel, message: "Build succeeded!")
        } else if (status == 'failure') {
            println "Sending failure notification to ${channel}"
            // Example: slackSend(channel: channel, message: "Build failed!")
        } else {
            throw new IllegalArgumentException("Unknown status: ${status}")
        }
    }
}
