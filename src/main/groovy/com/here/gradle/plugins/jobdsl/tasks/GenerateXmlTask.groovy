package com.here.gradle.plugins.jobdsl.tasks

import org.gradle.api.tasks.JavaExec

class GenerateXmlTask extends JavaExec {

    GenerateXmlTask() {
        super()
        group = 'Job DSL'
        description = 'Generate XML for all jobs.'
    }

    @Override
    void exec() {
        Map properties = [
                inputFiles     : project.sourceSets.jobdsl.allGroovy.asPath,
                outputDirectory: "${project.buildDir}/jobdsl/xml"
        ]
        setSystemProperties(properties)

        setMain('com.here.gradle.plugins.jobdsl.tasks.runners.GenerateXmlRunner')
        setClasspath(project.sourceSets.main.runtimeClasspath)

        super.exec()
    }

}