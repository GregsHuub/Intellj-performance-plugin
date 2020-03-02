package com.aptkode.ourFristPluginDemo

import java.lang.management.ManagementFactory

fun main() {

    val init = Performance()
    val processId = init.processId()
    println(processId.pcName)
    println(processId.pid)
    println(processId.memoryHeap)
    println("total used memoryL " + init.usedMemory())
    println("total free memory: " + init.totalFreeMemory())
    println("total memory: " + init.totalMemory())
//    val commands = listOf<String>("powershell.exe", "")

}

class Performance() {
    lateinit var pid: String
    lateinit var pcName: String
    var memoryHeap: Long = 0

    constructor(pid: String, pcName: String, memoryHeap: Long) : this() {
        this.pid = pid
        this.pcName = pcName
        this.memoryHeap = memoryHeap
    }

    fun processId(): Performance {
//        val processBuilder = ProcessBuilder()
//        val process = processBuilder.start()
        val prePid = ManagementFactory.getRuntimeMXBean().name
        val memory = ManagementFactory.getMemoryMXBean().heapMemoryUsage.used
        val processIdDetails = prePid.split("@")
        return Performance(processIdDetails[0], processIdDetails[1], memory)
    }

    //all in bytes
    fun builder(commands: List<String>) {
        val procBuild = ProcessBuilder()
        val runCommands = procBuild.command(commands)
    }

    fun usedMemory(): Long {
        val total = Runtime.getRuntime().totalMemory()
        val free = Runtime.getRuntime().freeMemory()
        val usedMemory = total - free
        return (usedMemory / 1024L)
    }
    fun totalFreeMemory():Long {
        val freeMemory = Runtime.getRuntime().totalMemory() - usedMemory()
        return (freeMemory / 1024L)
    }
    fun totalMemory(): Long {
        val totalMemory = Runtime.getRuntime().totalMemory()
        return (totalMemory / 1024L)
    }



}
