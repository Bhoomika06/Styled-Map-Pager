package com.thebrownarrow.utils;

import com.thebrownarrow.model.MyLocation;

import java.util.ArrayList;

/*
 * Created by iblinfotech on 04/03/17.
 */


public class GlobalUtils {
    private static ArrayList<MyLocation> latLngsArrayList = new ArrayList<>();

    public static ArrayList<MyLocation> getLatLongArray() {

        addLocations(34.053697, -118.401716);
        addLocations(34.083017, 118.38951500000002);
        addLocations(34.0508937, -118.2483757);
        addLocations(34.101059, -118.3163313);
        addLocations(34.0984372, -118.30793849999998);
        addLocations(34.1598974, -118.31221519999997);
        addLocations(34.1012814, -118.31296900000001);
        addLocations(34.1490401, -118.2840485);
        addLocations(4.1015875, -118.33364089999998);
        addLocations(34.1015875, -118.33364089999998);
        addLocations(34.029298, -118.38770850000003);
        addLocations(34.1582665, -118.2518697);
        addLocations(34.04776330000001, -118.2495151);
        addLocations(33.9451969, -118.1824534);
        addLocations(34.15412490000001, -118.3081143);
        addLocations(34.02128249999999, -118.383893);
        addLocations(34.1314077, -118.35717339999997);
        addLocations(34.0875285,-118.2914811);
        addLocations(34.095153, -118.1276367);
        addLocations(34.14839259999999, -118.284088);
        addLocations(33.9613703, -118.3658985);
        addLocations(34.0907297, -118.32014520000001);
        addLocations(34.01707689999999, -118.2886818);
        addLocations(34.0708996, -118.40338020000002);
        addLocations(34.0424905, -118.3641055);
        addLocations(34.0721585, -118.40604589999998);
        addLocations(34.0978922, -118.2474823);
        addLocations(34.0875221, -118.29144969999999);
        addLocations(34.1612415, -118.3100729);
        addLocations(34.0642806, -118.37025940000001);
        addLocations(34.1002972, -118.3271408);
        addLocations(34.09316029999999, -118.37833469999998);
        addLocations(34.0515954, -118.38369210000002);
        addLocations(34.0917299, -118.3236639);
        addLocations(34.01707689999999, -118.2886818);
        addLocations(34.08299360000001, -118.24611379999999);
        addLocations(34.1314077, -118.35717339999997);
        addLocations(34.1279922, -118.1559945);
        addLocations(34.0724615, -118.35809949999998);
        addLocations(34.0724304, -118.29071620000002);
        addLocations(34.1582665, -118.2518697);
        addLocations(34.0689235, -118.34681560000001);
        addLocations(33.9800122, -34.0505437);
        addLocations(34.02128249999999, -118.383893);
        addLocations(34.0907297, -118.32014520000001);
        addLocations(34.10248350000001, -118.33849270000002);
        addLocations(34.0606142, -118.3198308);
        addLocations(34.02128249999999, -118.383893);
        addLocations(34.0666534, -118.40100180000002);
        addLocations(34.0515954, -118.3836921);
        addLocations(34.0642254, -118.3701274);
        addLocations(34.1487314, -118.3386863);
        addLocations(34.0447628, -118.26542890000002);
        addLocations(34.0485099, -118.2532776);
        addLocations(34.0563289, -118.24677129999998);
        addLocations(34.073873, -118.24077740000001);
        addLocations(34.1490401, -118.2840485);
        addLocations(34.0724615, -118.35809949999998);
        addLocations(34.0485099, -118.25327759999999);
        addLocations(34.0638208, -118.35546269999998);
        addLocations(34.0724615, -118.35809949999998);
        addLocations(34.0951536, -118.12763719999998);
        addLocations(34.1016325, -118.32694479999998);
        addLocations(34.01775, -118.34394800000001);
        addLocations(34.0997032, -118.3380494);
        addLocations(34.0485099, -118.25327759999999);
        addLocations(34.1013684, -118.33669350000002);
        addLocations(33.97802970000001, -118.39154810000002);
        addLocations(34.1010998, -118.33836450000001);
        addLocations(34.06177009999999, -118.38376970000002);
        addLocations(34.1520338, -118.35111340000003);
        addLocations(34.0538577, -8.403);
        addLocations(34.07, -118.34326529999998);
        addLocations(34.1490401, -118.2840485);
        addLocations(34.1183754, -118.30035429999998);
        addLocations(34.0599922, -118.42000949999999);
        addLocations(34.14870620000001, -118.28146600000002);
        addLocations(34.0402652, -118.26954390000003);
        addLocations(34.0664768, -118.3802384);
        addLocations(33.9447902, -118.27880299999998);
        addLocations(34.0230659, -118.3955489);
        addLocations(34.015825, -118.2835862);
        addLocations(34.1044575, -118.3417063);
        addLocations(34.14904009999999, -118.28404849999998);
        addLocations(34.1411467, -118.2581995);
        addLocations(34.0632081, -118.2041049);
        addLocations(34.0440835, -118.254145);
        addLocations(34.0622501, -118.35555620000002);
        addLocations(34.01707689999999, -118.2886818);
        addLocations(34.0632081, -118.2041049);
        addLocations(34.1486202, -118.28121320000002);
        addLocations(34.053697, -118.40171599999996);
        addLocations(34.1012814, -118.31296900000001);
        addLocations(34.0667443, -118.4007231);
        addLocations(34.1279922, -118.1559945);
        addLocations(34.0632081, -118.2041049);
        addLocations(34.095153, -118.1276367);
        addLocations(34.0532024, -118.3836728);
        addLocations(34.15830049999999, -118.23985340000002);
        addLocations(34.1490401, -118.2840485);
        addLocations(34.0532024, -118.3836728);
        addLocations(34.070926, -118.40338700000001);
        addLocations(34.0424905, -118.3641055);
        addLocations(34.0167667, -118.334676);
        addLocations(34.0632081, -118.2041049);
        addLocations(34.0566067, -118.24893250000002);
        addLocations(34.02128249999999, -118.383893);
        addLocations(34.0115008, -118.3461894);
        addLocations(34.0717892, -118.36057249999999);
        addLocations(34.0923467, -118.12561749999998);
        addLocations(34.1462414, -118.15923829999997);
        addLocations(34.01707689999999, -118.2886818);
        addLocations(34.1281815, -118.27122610000004);
        addLocations(34.1553975, -118.30057850000003);
        addLocations(34.1281815, -118.2712261);
        addLocations(34.05026869999999, -118.25504330000001);
        addLocations(34.1360331, -118.352791);
        addLocations(34.1573164, -118.28996899999999);
        addLocations(34.0612412, -118.39881839999998);
        addLocations(34.1013467, -118.3331053);
        addLocations(34.1025903, -118.3400444);
        addLocations(33.9451969, -118.1824534);
        addLocations(33.9705223, -118.28014139999999);
        addLocations(34.0508937, -118.2483757);
        addLocations(34.14888289999999, -118.25417270000003);
        addLocations(34.0314858, -118.4104719);
        addLocations(34.043125, -118.26711799999998);
        addLocations(34.0880775, -118.208078);
        addLocations(34.0753309, -118.37749329999997);
        addLocations(34.14904009999999, -118.28404849999998);
        addLocations(34.0632081, -118.2041049);
        addLocations(34.083017, 118.389515000002);


        return latLngsArrayList;
    }

    private static void addLocations(double latitude, double longitude) {
        MyLocation location = new MyLocation(latitude, longitude);
        latLngsArrayList.add(location);
    }
}
