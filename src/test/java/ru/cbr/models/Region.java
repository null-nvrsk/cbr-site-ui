package ru.cbr.models;

public enum Region {

    RU_01("Алтайский край"),
    RU_10("Амурская область"),
//    RU_11("Архангельская область"),
//    RU_12("Астраханская область"),
//    RU_14("Белгородская область"),
//    RU_15("Брянская область"),
//    RU_17("Владимирская область"),
//    RU_18("Волгоградская область"),
//    RU_19("Вологодская область"),
//    RU_20("Воронежская область"),
    RU_45("город Москва"),
    RU_40("город Санкт-Петербург"),
//    RU_67("город Севастополь"),
//    RU_21("Донецкая Народная Республика"),
//    RU_99("Еврейская автономная область"),
//    RU_76("Забайкальский край"),
//    RU_23("Запорожская область"),
//    RU_24("Ивановская область"),
//    RU_25("Иркутская область"),
//    RU_83("Кабардино-Балкарская Республика"),
//    RU_27("Калининградская область"),
//    RU_29("Калужская область"),
//    RU_30("Камчатский край"),
//    RU_91("Карачаево-Черкесская Республика"),
//    RU_32("Кемеровская область - Кузбасс"),
//    RU_33("Кировская область"),
//    RU_34("Костромская область"),
//    RU_03("Краснодарский край"),
//    RU_04("Красноярский край"),
//    RU_37("Курганская область"),
//    RU_38("Курская область"),
//    RU_41("Ленинградская область"),
//    RU_42("Липецкая область"),
//    RU_43("Луганская Народная Республика"),
//    RU_44("Магаданская область"),
//    RU_46("Московская область"),
//    RU_47("Мурманская область"),
    RU_11_100("Ненецкий автономный округ"),
//    RU_22("Нижегородская область"),
//    RU_49("Новгородская область"),
//    RU_50("Новосибирская область"),
//    RU_52("Омская область"),
//    RU_53("Оренбургская область"),
//    RU_54("Орловская область"),
//    RU_56("Пензенская область"),
//    RU_57("Пермский край"),
//    RU_05("Приморский край"),
//    RU_58("Псковская область"),
//    RU_79("Республика Адыгея (Адыгея)"),
//    RU_84("Республика Алтай"),
//    RU_80("Республика Башкортостан"),
//    RU_81("Республика Бурятия"),
//    RU_82("Республика Дагестан"),
//    RU_26("Республика Ингушетия"),
//    RU_85("Республика Калмыкия"),
//    RU_86("Республика Карелия"),
//    RU_87("Республика Коми"),
//    RU_35("Республика Крым"),
//    RU_88("Республика Марий Эл"),
//    RU_89("Республика Мордовия"),
//    RU_98("Республика Саха (Якутия)"),
//    RU_90("Республика Северная Осетия - Алания"),
//    RU_92("Республика Татарстан (Татарстан)"),
//    RU_93("Республика Тыва"),
//    RU_95("Республика Хакасия"),
//    RU_60("Ростовская область"),
//    RU_61("Рязанская область"),
//    RU_36("Самарская область"),
//    RU_63("Саратовская область"),
//    RU_64("Сахалинская область"),
//    RU_65("Свердловская область"),
//    RU_66("Смоленская область"),
//    RU_07("Ставропольский край"),
//    RU_68("Тамбовская область"),
//    RU_28("Тверская область"),
//    RU_69("Томская область"),
//    RU_70("Тульская область"),
//    RU_71("Тюменская область"),
//    RU_94("Удмуртская Республика"),
//    RU_73("Ульяновская область"),
//    RU_08("Хабаровский край"),
//    RU_71_100("Ханты-Мансийский автономный округ - Югра"),
//    RU_74("Херсонская область"),
//    RU_75("Челябинская область"),
//    RU_96("Чеченская Республика"),
//    RU_97("Чувашская Республика - Чувашия"),
//    RU_77("Чукотский автономный округ"),
    RU_71_140("Ямало-Ненецкий автономный округ"),
    RU_78("Ярославская область");

    public final String description;

    Region(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        return description;
    }
}