/*
 * Project: ARUBA
 * Class:   Zip
 *
 * Version info
 * Created: 2017-05-02
 * Creator: Desireé Björkman
 *
 * Copyright notice
 * Property of Fasbros IT. Do not copy, alter, distribute, or sell in any way unless given
 * explicit permission.
 */

package com;

/**
 * Class summary.
 * An estimation of the middle point of zips that exists in Sweden
 * Class Description.
 * </p>
 *
 * @author Desireé Björkman <dessexd@hotmail.com>
 * @version JDK 1.8
 * @since JDK 1.8
 */
public class Zip {

    private int zipNumber;
    private Geocoordinate geocoordinate;


    public Zip(int zipNumber) {
        this.zipNumber = zipNumber;
        switch (zipNumber) {
            case 10:
                this.geocoordinate = new Geocoordinate(59.34719533619743, 18.095855712890625);
                break;
            case 11:
                this.geocoordinate = new Geocoordinate(59.32968704671643, 18.070449829101562);
                break;
            case 12:
                this.geocoordinate = new Geocoordinate(59.29223280827166, 18.076629638671875);
                break;
            case 13:
                this.geocoordinate = new Geocoordinate(59.177335579087384, 18.26751708984375);
                break;
            case 14:
                this.geocoordinate = new Geocoordinate(59.0673897587792, 17.9296875);
                break;
            case 15:
                this.geocoordinate = new Geocoordinate(59.19536300000001, 17.625688999999966);
                break;
            case 16:
                this.geocoordinate = new Geocoordinate(59.3670471, 17.966309300000034);
                break;
            case 17:
                this.geocoordinate = new Geocoordinate(59.3672437, 17.695956799999976);
                break;
            case 18:
                this.geocoordinate = new Geocoordinate(59.63443457494949, 18.25103759765625);
                break;
            case 19:
                this.geocoordinate = new Geocoordinate(59.6196463, 17.85550939999996);
                break;
            case 20:
                this.geocoordinate = new Geocoordinate(55.68377855290114, 13.088836669921875);
                break;
            case 21:
                this.geocoordinate = new Geocoordinate(55.604981, 13.003822000000014);
                break;
            case 22:
                this.geocoordinate = new Geocoordinate(55.7046601, 13.191007300000024);
                break;
            case 23:
                this.geocoordinate = new Geocoordinate(55.551103, 13.267608600000017);
                break;
            case 24:
                this.geocoordinate = new Geocoordinate(55.851716, 13.661925500000052);
                break;
            case 25:
                this.geocoordinate = new Geocoordinate(56.0464674, 12.694512099999997);
                break;
            case 26:
                this.geocoordinate = new Geocoordinate(56.12488787121737, 13.10943603515625);
                break;
            case 27:
                this.geocoordinate = new Geocoordinate(55.54355, 13.95483999999999);
                break;
            case 28:
                this.geocoordinate = new Geocoordinate(56.15891449999999, 13.76676550000002);
                break;
            case 29:
                this.geocoordinate = new Geocoordinate(56.0743618, 14.477659000000017);
                break;
            case 30:
                this.geocoordinate = new Geocoordinate(56.6743748, 12.857788400000004);
                break;
            case 31:
                this.geocoordinate = new Geocoordinate(56.50575569999999, 13.045604799999978);
                break;
            case 32:
                this.geocoordinate = new Geocoordinate(56.8025533, 12.969062000000008);
                break;
            case 33:
                this.geocoordinate = new Geocoordinate(57.29388636800383, 13.55712890625);
                break;
            case 34:
                this.geocoordinate = new Geocoordinate(56.8338774, 13.941041700000028);
                break;
            case 35:
                this.geocoordinate = new Geocoordinate(56.8790044, 14.805852200000004);
                break;
            case 36:
                this.geocoordinate = new Geocoordinate(56.75126419999999, 15.270000799999934);
                break;
            case 37:
                this.geocoordinate = new Geocoordinate(56.2427292, 15.291612999999984);
                break;
            case 38:
                this.geocoordinate = new Geocoordinate(56.8382325, 15.742019700000014);
                break;
            case 39:
                this.geocoordinate = new Geocoordinate(56.6634447, 16.35677899999996);
                break;
            case 40:
                this.geocoordinate = new Geocoordinate(57.766667, 11.866667000000007);
                break;
            case 41:
                this.geocoordinate = new Geocoordinate(57.70887, 11.974559999999997);
                break;
            case 42:
                this.geocoordinate = new Geocoordinate(57.5930786, 11.9538728);
                break;
            case 43:
                this.geocoordinate = new Geocoordinate(57.354479, 12.476311600000031);
                break;
            case 44:
                this.geocoordinate = new Geocoordinate(57.9300205, 12.53621129999999);
                break;
            case 45:
                this.geocoordinate = new Geocoordinate(58.61374129999998, 11.470808000000034);
                break;
            case 46:
                this.geocoordinate = new Geocoordinate(58.3797283, 12.32480320000002);
                break;
            case 47:
                this.geocoordinate = new Geocoordinate(58.18664149999999, 11.606918899999982);
                break;
            case 50:
                this.geocoordinate = new Geocoordinate(57.72103500000001, 12.939818999999943);
                break;
            case 51:
                this.geocoordinate = new Geocoordinate(57.4955715, 13.114622499999996);
                break;
            case 52:
                this.geocoordinate = new Geocoordinate(58.17502899999999, 13.553217000000018);
                break;
            case 53:
                this.geocoordinate = new Geocoordinate(58.528002, 13.491428000000042);
                break;
            case 54:
                this.geocoordinate = new Geocoordinate(58.8516394, 14.217439900000045);
                break;
            case 55:
                this.geocoordinate = new Geocoordinate(57.78261370000001, 14.161787600000025);
                break;
            case 56:
                this.geocoordinate = new Geocoordinate(57.4989621, 14.148629700000015);
                break;
            case 57:
                this.geocoordinate = new Geocoordinate(57.42746, 15.085329999999999);
                break;
            case 58:
                this.geocoordinate = new Geocoordinate(58.41080700000001, 15.621372699999938);
                break;
            case 59:
                this.geocoordinate = new Geocoordinate(58.2007895, 15.997698600000035);
                break;
            case 60:
                this.geocoordinate = new Geocoordinate(58.587745, 16.192420999999968);
                break;
            case 61:
                this.geocoordinate = new Geocoordinate(58.6756076, 16.37010889999999);
                break;
            case 62:
                this.geocoordinate = new Geocoordinate(57.46841209999999, 18.48674470000003);
                break;
            case 63:
                this.geocoordinate = new Geocoordinate(59.37124859999999, 16.509804499999973);
                break;
            case 64:
                this.geocoordinate = new Geocoordinate(59.0579376, 16.587912200000005);
                break;
            case 65:
                this.geocoordinate = new Geocoordinate(59.4021806, 13.511497700000064);
                break;
            case 66:
                this.geocoordinate = new Geocoordinate(59.05111699999999, 12.697732299999984);
                break;
            case 67:
                this.geocoordinate = new Geocoordinate(59.6548534, 12.592135999999982);
                break;
            case 68:
                this.geocoordinate = new Geocoordinate(60.172769, 13.496454900000003);
                break;
            case 69:
                this.geocoordinate = new Geocoordinate(58.88942679999999, 14.910986699999967);
                break;
            case 70:
                this.geocoordinate = new Geocoordinate(59.2752626, 15.213410500000009);
                break;
            case 71:
                this.geocoordinate = new Geocoordinate(59.6741711, 14.810097100000007);
                break;
            case 72:
                this.geocoordinate = new Geocoordinate(59.60990049999999, 16.544809100000066);
                break;
            case 73:
                this.geocoordinate = new Geocoordinate(59.761928157970196, 15.8477783203125);
                break;
            case 74:
                this.geocoordinate = new Geocoordinate(59.979753869146464, 17.30072021484375);
                break;
            case 75:
                this.geocoordinate = new Geocoordinate(59.85856380000001, 17.638926699999956);
                break;
            case 76:
                this.geocoordinate = new Geocoordinate(59.7436995, 18.3601496);
                break;
            case 77:
                this.geocoordinate = new Geocoordinate(60.152358, 15.19163900000001);
                break;
            case 78:
                this.geocoordinate = new Geocoordinate(60.686372, 13.720965999999976);
                break;
            case 79:
                this.geocoordinate = new Geocoordinate(61.004878, 14.537003000000027);
                break;
            case 80:
                this.geocoordinate = new Geocoordinate(60.6748796, 17.14127259999998);
                break;
            case 81:
                this.geocoordinate = new Geocoordinate(60.621607, 16.775918000000047);
                break;
            case 82:
                this.geocoordinate = new Geocoordinate(61.4702685, 16.37932360000002);
                break;
            case 83:
                this.geocoordinate = new Geocoordinate(63.85366209999999, 15.556869099999972);
                break;
            case 84:
                this.geocoordinate = new Geocoordinate(62.4447051, 13.862043399999948);
                break;
            case 85:
                this.geocoordinate = new Geocoordinate(62.390811, 17.306926999999973);
                break;
            case 86:
                this.geocoordinate = new Geocoordinate(62.53486179999999, 17.147533100000032);
                break;
            case 87:
                this.geocoordinate = new Geocoordinate(63.00667439999999, 17.756424899999956);
                break;
            case 88:
                this.geocoordinate = new Geocoordinate(63.1654065, 17.277135000000044);
                break;
            case 89:
                this.geocoordinate = new Geocoordinate(63.45048019999999, 18.1031299);
                break;
            case 90:
                this.geocoordinate = new Geocoordinate(63.8258471, 20.263035400000035);
                break;
            case 91:
                this.geocoordinate = new Geocoordinate(64.1602339, 17.35361499999999);
                break;
            case 92:
                this.geocoordinate = new Geocoordinate(65.0649864, 17.15982980000001);
                break;
            case 93:
                this.geocoordinate = new Geocoordinate(65.5920768, 19.180282799999986);
                break;
            case 94:
                this.geocoordinate = new Geocoordinate(65.316698, 21.480036400000017);
                break;
            case 95:
                this.geocoordinate = new Geocoordinate(65.9198012, 23.405625900000018);
                break;
            case 96:
                this.geocoordinate = new Geocoordinate(66.60696089999999, 19.822920599999975);
                break;
            case 97:
                this.geocoordinate = new Geocoordinate(65.584819, 22.156702600000017);
                break;
            case 98:
                this.geocoordinate = new Geocoordinate(67.8557995, 20.22528209999996);
                break;
            default:
                break;
        }
    }


    public int getZip() {
        return zipNumber;
    }

    public Geocoordinate getGeocoordinate() {
        return geocoordinate;
    }

}