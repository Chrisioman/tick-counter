package PvMTickCounter;

import java.util.HashMap;

public class TickCounterUtil {
    HashMap<Integer, Integer> aniTM;

    public void init(){
        aniTM = new HashMap<>();

        aniTM.put(7855, -1); // Mixed ticks - surge (5) /harm orb (4)
        aniTM.put(426, -1); // bow shoot
        aniTM.put(390, -1); // Generic Slash (4) + swift blade (3) + Osmumten's Fang (5)
        aniTM.put(8288, -1); // dhl Stab (4)  + swift blade (3)
        aniTM.put(393, -1); // Staff bash (5) + Claw Scratch (4)
        aniTM.put(400, -1); // Pickaxe smash (5) + Inquisitor's Mace Stab (4)
        aniTM.put(401, -1); // dwh bop (6) + Ham Joint (3) + (axe + pickaxe) (5)

        aniTM.put(7617, 2); // rune knife
        aniTM.put(8194, 2); // dragon knife
        aniTM.put(5061, 2); // blowpipe

        aniTM.put(2323, 3); // Event RPG
        aniTM.put(7618, 3); // Chinchompa
        aniTM.put(2075, 3); // Karil's CB

        aniTM.put(376, 4); // dds stab
        aniTM.put(377, 4); // dds slash
        aniTM.put(422, 4); // punch
        aniTM.put(423, 4); // kick
        aniTM.put(381, 4); // Zamorakian Hasta
        aniTM.put(386, 4); // lunge
        aniTM.put(419, 4); // Keris Smash
        aniTM.put(1062, 4); // dds spec
        aniTM.put(1067, 4); // claw stab
        aniTM.put(1167, 4); // trident cast
        aniTM.put(1658, 4); // whip
        aniTM.put(2890, 4); // Arclight Special
        aniTM.put(3294, 4); // Abby Dagger Slash
        aniTM.put(3297, 4); // Abby Dagger Poke
        aniTM.put(3298, 4); // Bludgeon Attack
        aniTM.put(3299, 4); // Bludgeon Spec
        aniTM.put(3300, 4); // Abby Dagger Spec
        aniTM.put(7514, 4); // Claw Spec
        aniTM.put(7515, 4); // Dragon Sword Spec
        aniTM.put(8145, 4); // Rapier
        aniTM.put(8289, 4); // Dhl Slash
        aniTM.put(8290, 4); // Dhl Crush
        aniTM.put(4503, 4); // Inquisitor's Mace Crush
        aniTM.put(1711, 4); // Zamorakian Spear

        aniTM.put(395, 5); //Axe
        aniTM.put(2062, 5); // Verac's Flail
        aniTM.put(2068, 5); // Torag's Hammers
        aniTM.put(2080, 5); // Guthans Warspear
        aniTM.put(2081, 5);
        aniTM.put(2082, 5);
        aniTM.put(1162, 5); // strike/bolt spells
        aniTM.put(1379, 5); // Bursting/Blitz spells
        aniTM.put(1979, 5); // Barrage Spell
        aniTM.put(6118, 5); // Osmumten's Fang Special
        aniTM.put(9471, 5); // Osmumten's Fang Stab
        aniTM.put(7552, 5); // Generic Crossbow
        aniTM.put(9493, 5); // Tumeken's Shadow
        aniTM.put(8056, 5); // Scythe Swing

        aniTM.put(1378, 6);
        aniTM.put(7045, 6);
        aniTM.put(7054, 6);
        aniTM.put(2078, 6); // Ahrim's Staff
        aniTM.put(5865, 6); // Barrelchest Anchor
        aniTM.put(5870, 6); // Barrelchest Special
        aniTM.put(7055, 6); // godsword autos
        aniTM.put(7511, 6); // dinh's attack
        aniTM.put(7516, 6); // maul attack
        aniTM.put(7555, 6); // ballista attack
        aniTM.put(7638, 6); // zgs spec
        aniTM.put(7640, 6); // sgs spec
        aniTM.put(7642, 6); // bgs spec
        aniTM.put(7643, 6); // bgs spec
        aniTM.put(7644, 6); // ags spec

        aniTM.put(428, 7); // Chally swipe
        aniTM.put(440, 7); // Chally jab
        aniTM.put(1203, 7); // Chally spec
        aniTM.put(2066, 7); // DH axe
        aniTM.put(2067, 7); // DH Axe Smash

        aniTM.put(9544, 12); // Keris of Curruption Spec

    }

    public Integer getTicks(Integer animationID, Integer weaponID)
    {
        Integer ticks = aniTM.getOrDefault(animationID, 0);
        if(ticks > 0){
            return ticks;
        }else{
            if(animationID == 7855){
                if(weaponID == 24423)
                    return 4;
                else
                    return 5;

            }if (animationID == 426) {
                if (weaponID == 25886 || weaponID == 25867 || weaponID == 25869 || weaponID == 25884 || weaponID == 25888 || weaponID == 25890 || weaponID == 25892 || weaponID == 25894 || weaponID == 25896 || weaponID == 25865)
                    return 4;
                else if (weaponID == 20997) {
                    return 5;
                } else
                    return 3;

            }if (animationID == 390) {
                if (weaponID == 26219) {
                    return 5;
                } else if (weaponID == 24219) {
                    return 3;
                }  else
                    return 4;

            }if (animationID == 8288) {
                if (weaponID == 24219) {
                    return 3;
                }  else
                    return 4;

            }if (animationID == 393) {
                if (weaponID == 13652) {
                    return 4;
                }  else
                    return 5;

            }if (animationID == 400) {
                if (weaponID == 24417) {
                    return 4;
                }  else
                    return 5;

            }if (animationID == 401) {
                if (weaponID == 13576) { //dwh
                    return 6;
                } else if (weaponID == 23360) { // ham joint
                    return 3;
                } else
                    return 5;


            }

        }
        return 0;
    }
}