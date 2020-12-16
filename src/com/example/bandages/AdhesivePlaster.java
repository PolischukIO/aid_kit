package com.example.bandages;

import com.example.Material;

public class AdhesivePlaster extends BandagingMaterial {

    public AdhesivePlaster(int width, int length, Material material, boolean sterile) {
        super(width, length, material, sterile);
    }

    @Override
    public void bandageWound() {
        System.out.println("Wound was bandaged by plaster");
    }

}

//10)+ Використати метод String.split(...) для розділення строки за критерієм обраного символу. Перед виконанням прочитати https://www.baeldung.com/string/split (1 бал)
//13)+ Кидати вами створену помилку та інші за необхідності, обробляти їх у влучному місці за допомогою блоку try-catch-finally (1 бал)+
//15)+ Перевизначити метод equals або hashCode у одному з ваших класів, використати перевизначений метод для перевірки об’єктів цього класу. (1 бал)
//16)+ наявний вкладений (nested) клас (1 бал) 0.5
//17)+ присутня асоціація класів (1 бал)