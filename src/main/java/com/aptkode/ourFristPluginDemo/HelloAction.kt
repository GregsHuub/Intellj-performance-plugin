package com.aptkode.ourFristPluginDemo

import com.intellij.openapi.actionSystem.AnAction
import com.intellij.openapi.actionSystem.AnActionEvent
import com.intellij.openapi.fileChooser.FileChooser
import com.intellij.openapi.fileChooser.FileChooserDescriptor
import com.intellij.openapi.ui.Messages
import java.time.LocalDateTime

/**
 * 27/02/2019
 * @author No one
 */
class HelloAction : AnAction() {
    override fun actionPerformed(e: AnActionEvent) {
        val fileChooserDescriptor = FileChooserDescriptor(
            false,
            true,
            false,
            false,
            false,
            false
        )
        fileChooserDescriptor.title = "Pick directory(test)"
        fileChooserDescriptor.description = "windows description(test)"
        val nowTime = LocalDateTime.now()

        FileChooser.chooseFile(fileChooserDescriptor, e.project, null) {
            // drugi param, to wyswietlany komunikat
//            Messages.showMessageDialog(e.project, it.path, "path", Messages.getInformationIcon())
            Messages.showMessageDialog(e.project, nowTime.toString(), "path", Messages.getInformationIcon())

        }
    }

}

