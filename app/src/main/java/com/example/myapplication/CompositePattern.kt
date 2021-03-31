package com.example.myapplication

class CompositePattern(override val name: String) : FileFolderComponent {
    val allFiles:ArrayList<FileFolderComponent> = ArrayList()
    init {
        allFiles.add(Folder(name))
    }

    override fun display()  = allFiles.forEach(FileFolderComponent::display)

    fun add(component: FileFolderComponent) {
        allFiles.add(component)
    }
    fun remove(component: FileFolderComponent) {
        allFiles.remove(component)
    }

}

interface FileFolderComponent {
    val name: String
    fun display()
}

class Folder(override val name: String) : FileFolderComponent  {
    val contents:ArrayList<FileFolderComponent> = ArrayList()
    fun addComponent(folder: FileFolderComponent) {
        this.contents.add(folder)
    }
    override fun display() {
        println(name)
        this.contents.forEach(FileFolderComponent::display)
    }

}


class File(override val name: String)  : FileFolderComponent  {
    override fun display() {
        println(name)
    }

}