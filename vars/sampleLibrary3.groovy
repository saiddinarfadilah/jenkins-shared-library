// vars/sampleLibrary.groovy

def buildProject(String buildTool) {
    // Memanggil metode buildProject dari SampleHelper2
    com.example.SampleHelper2.buildProject(buildTool, this)
}

def runTests(String testTool) {
    // Memanggil metode runTests dari SampleHelper2
    com.example.SampleHelper2.runTests(testTool, this)
}

def notify(String status, String channel) {
    // Memanggil metode notify dari SampleHelper2
    com.example.SampleHelper2.notify(status, channel, this)
}
