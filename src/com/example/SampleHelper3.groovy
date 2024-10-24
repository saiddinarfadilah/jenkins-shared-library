package com.example

class SampleHelper3 {

    // Menjalankan perintah build berdasarkan OS
    static void runBuildCommand(String command, def script) {
        if (isWindows(script)) {
            // Gunakan step bawaan Jenkins untuk Windows
            script.bat command
        } else {
            // Gunakan step bawaan Jenkins untuk Linux/MacOS
            script.sh command
        }
    }

    // Memeriksa apakah lingkungan saat ini adalah Windows
    static boolean isWindows(def script) {
        return script.isUnix() == false
    }

    // Fungsi untuk membaca file properties
    static Properties loadProperties(def script, String filename) {
        def props = new Properties()
        def inputStream = script.getClass().getClassLoader().getResourceAsStream(filename)
        if (inputStream) {
            props.load(inputStream)
        } else {
            script.error("File ${filename} tidak ditemukan!")
        }
        return props
    }

    // Metode untuk mencetak konfigurasi
    static void printConfig(def script) {
        def config = loadProperties(script, 'config.properties')
        script.echo "Nama Aplikasi: ${config['app.name']}"
        script.echo "Versi Aplikasi: ${config['app.version']}"
        script.echo "Lingkungan: ${config['app.environment']}"
    }

    // Metode untuk membangun proyek
    static void buildProject(def script) {
        def config = loadProperties(script, 'config.properties')
        def buildTool = config['build.tool']

        if (buildTool == 'maven') {
            script.echo "Membangun proyek dengan Maven..."
            runBuildCommand('mvn clean install', script)
        } else if (buildTool == 'gradle') {
            script.echo "Membangun proyek dengan Gradle..."
            runBuildCommand('./gradlew build', script)
        } else {
            throw new IllegalArgumentException("Alat build tidak dikenal: ${buildTool}")
        }
    }

    // Metode untuk menjalankan pengujian
    static void runTests(def script) {
        def config = loadProperties(script, 'config.properties')
        def testTool = config['build.tool']

        if (testTool == 'maven') {
            script.echo "Menjalankan pengujian dengan Maven..."
            runBuildCommand('mvn test', script)
        } else if (testTool == 'gradle') {
            script.echo "Menjalankan pengujian dengan Gradle..."
            runBuildCommand('./gradlew test', script)
        } else {
            throw new IllegalArgumentException("Alat pengujian tidak dikenal: ${testTool}")
        }
    }

    // Metode untuk mengirim notifikasi berdasarkan hasil
    static void notify(String status, def script) {
        def config = loadProperties(script, 'config.properties')
        def channel = config['notify.channel']

        if (status == 'success') {
            script.echo "Mengirim notifikasi sukses ke ${channel}"
            // Contoh: script.slackSend(channel: channel, message: "Build berhasil!")
        } else if (status == 'failure') {
            script.echo "Mengirim notifikasi gagal ke ${channel}"
            // Contoh: script.slackSend(channel: channel, message: "Build gagal!")
        } else {
            throw new IllegalArgumentException("Status tidak dikenal: ${status}")
        }
    }
}
