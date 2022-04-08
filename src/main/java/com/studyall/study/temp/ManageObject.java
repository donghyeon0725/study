package com.studyall.study.temp;

import java.io.*;

public class ManageObject {
    public static void main(String[] args) throws IOException {
        ManageObject manageObject = new ManageObject();
        String fullPath = "serial.object";

        SerialDTO dto = new SerialDTO("java", 1, true, 100);
        manageObject.saveObject(fullPath, dto);
        SerialDTO serialDTO = manageObject.readObject(fullPath);
        System.out.println(serialDTO);
    }

    private void saveObject(String fullPath, SerialDTO dto) {

        try (
            FileOutputStream fos = new FileOutputStream(fullPath);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
        ) {
            oos.writeObject(dto);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private SerialDTO readObject(String fullPath) {
        try (
            FileInputStream fis = new FileInputStream(fullPath);
            ObjectInputStream ois = new ObjectInputStream(fis);
        ) {
            SerialDTO serialDTO = (SerialDTO) ois.readObject();
            return serialDTO;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
