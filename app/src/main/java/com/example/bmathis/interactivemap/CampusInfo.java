//File name: CampusInfo.java
//Authors: Ben Wilfong, Brandon Mathis
//File Description: Contains information about buildings and locations on campus
//Last Edited: 05/06/2016

package com.example.bmathis.interactivemap;

import android.graphics.Color;
import android.widget.Toast;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.LatLngBounds;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.Polygon;
import com.google.android.gms.maps.model.PolygonOptions;
import com.google.android.gms.maps.model.Polyline;
import com.google.android.gms.maps.model.PolylineOptions;
import java.util.Vector;

public class CampusInfo
{
    GoogleMap map;
    MapsActivity mapsActivity;
    LatLng fairmont;
    LatLng[] campusBoundaryLines;
    LatLng[] schoolHouseCoordinates;
    LatLng[] parkingGarageCoordinates;
    LatLng[] hardwayCoordinates;
    LatLng[] bryantCoordinates;
    LatLng[] newmanCoordinates;
    LatLng[] jaynesCoordinates;
    LatLng[] morrowCoordinates;
    LatLng[] prichardCoordinates;
    LatLng[] penceCoordinates;
    LatLng[] shawCoordinates;
    LatLng[] feasterCenterCoordinates;
    LatLng[] duvallCoordinates;
    LatLng[] physicalPlantCoordinates;
    LatLng[] tennisCourtCoordinates;
    LatLng[] practiceFieldCoordinates;
    LatLng[] collegeParkCoordinates;
    LatLng[] folklifeCoordinates;
    LatLng[] huntHaughtCoordinates;
    LatLng[] libraryCoordinates;
    LatLng[] ETCoordinates;
    LatLng[] wallmanCoordinates;
    LatLng[] falconCenterCoordinates;
    LatLng[] turleyCoordinates;
    LatLng[] educationCoordinates;
    LatLng[] colebankCoordinates;
    LatLng[] alumniCenterCoordinates;
    LatLng[] wesleyCoordinates;
    LatLng falconCenterCenter;
    LatLng schoolHouseCenter;
    LatLng hardwayCenter;
    LatLng parkingGarageCenter;
    LatLng bryantCenter;
    LatLng newmanCenter;
    LatLng jaynesCenter;
    LatLng morrowCenter;
    LatLng prichardCenter;
    LatLng penceCenter;
    LatLng shawCenter;
    LatLng feasterCenterCenter;
    LatLng duvallCenter;
    LatLng physicalPlantCenter;
    LatLng tennisCourtCenter;
    LatLng practiceFieldCenter;
    LatLng collegeParkCenter;
    LatLng folklifeCenter;
    LatLng huntHaughtCenter;
    LatLng libraryCenter;
    LatLng ETCenter;
    LatLng wallmanCenter;
    LatLng turleyCenter;
    LatLng educationCenter;
    LatLng colebankCenter;
    LatLng alumniCenterCenter;
    LatLng wesleyCenter;
    Marker schoolHouseMarker;
    Marker hardwayMarker;
    Marker bryantMarker;
    Marker parkingGarageMarker;
    Marker newmanMarker;
    Marker jaynesMarker;
    Marker morrowMarker;
    Marker prichardMarker;
    Marker penceMarker;
    Marker shawMarker;
    Marker feasterCenterMarker;
    Marker duvallMarker;
    Marker physicalPlantMarker;
    Marker tennisCourtMarker;
    Marker practiceFieldMarker;
    Marker collegeParkMarker;
    Marker folklifeMarker;
    Marker huntHaughtMarker;
    Marker libraryMarker;
    Marker ETmarker;
    Marker FalconCenterMarker;
    Marker wallmanMarker;
    Marker turleyMarker;
    Marker educationMarker;
    Marker colebankMarker;
    Marker alumniCenterMarker;
    Marker wesleyMarker;
    PolylineOptions campusOutline;
    Polygon falconCenter;
    Polygon schoolHouse;
    Polygon hardway;
    Polygon parkingGarage;
    Polygon bryant;
    Polygon newman;
    Polygon jaynes;
    Polygon morrow;
    Polygon prichard;
    Polygon pence;
    Polygon shaw;
    Polygon feasterCenter;
    Polygon duvall;
    Polygon physicalPlant;
    Polygon tennisCourt;
    Polygon practiceField;
    Polygon collegePark;
    Polygon folklife;
    Polygon huntHaught;
    Polygon library;
    Polygon ET;
    Polygon wallman;
    Polygon turley;
    Polygon education;
    Polygon colebank;
    Polygon alumniCenter;
    Polygon wesley;
    int numBoundaryLines = 13;
    Vector[] bryantInfo;
    Vector[] colebankInfo;
    Vector[] collegeParkInfo;
    Vector[] duvallInfo;
    Vector[] ETInfo;
    Vector[] alumniCenterInfo;
    Vector[] falconCenterInfo;
    Vector[] feasterCenterInfo;
    Vector[] folklifeInfo;
    Vector[] hardwayInfo;
    Vector[] huntHaughtInfo;
    Vector[] jaynesInfo;
    Vector[] morrowInfo;
    Vector[] newmanInfo;
    Vector[] schoolHouseInfo;
    Vector[] parkingGarageInfo;
    Vector[] penceInfo;
    Vector[] physicalPlantInfo;
    Vector[] practiceFieldInfo;
    Vector[] prichardInfo;
    Vector[] libraryInfo;
    Vector[] educationInfo;
    Vector[] shawInfo;
    Vector[] tennisCourtInfo;
    Vector[] turleyInfo;
    Vector[] wallmanInfo;
    Vector[] wesleyInfo;
    Vector<Polyline> lineArray;
    Polyline falconCenterToSchoolHouse;
    Polyline falconCenterToHardway;
    Polyline falconCenterToParkingGarage;
    Polyline falconCenterToBryant;
    Polyline falconCenterToNewman;
    Polyline falconCenterToJaynes;
    Polyline falconCenterToMorrow;
    Polyline falconCenterToPrichard;
    Polyline falconCenterToPence;
    Polyline falconCenterToShaw;
    Polyline falconCenterToFeasterCenter;
    Polyline falconCenterToDuvall;
    Polyline falconCenterToPhysicalPlant;
    Polyline falconCenterToTennisCourts;
    Polyline falconCenterToPracticeField;
    Polyline falconCenterToCollegePark;
    Polyline falconCenterToFolklife;
    Polyline falconCenterToHuntHaught;
    Polyline falconCenterToLibrary;
    Polyline falconCenterToET;
    Polyline falconCenterToWallman;
    Polyline falconCenterToTurley;
    Polyline falconCenterToEducation;
    Polyline falconCenterToColebank;
    Polyline falconCenterToAlumniCenter;
    Polyline falconCenterToWesley;


    //==================================================================================================
//Default constructor for CampusInfo
    CampusInfo(GoogleMap mMap,MapsActivity tempMapActivity)
    {
        map = mMap;
        mapsActivity = tempMapActivity;
        makeCampusBoundaryLines();
        buildSchoolHouseOutline();
        buildHardwayOutline();
        buildParkingGarageOutline();
        buildBryantOutline();
        buildNewmanOutline();
        buildJaynesOutline();
        buildMorrowOutline();
        buildPrichardOutline();
        buildPenceOutline();
        buildShawOutline();
        buildFeasterCenterOutline();
        buildDuvallRosierOutline();
        buildPhysicalPlantOutline();
        buildTennisCourtsOutline();
        buildPracticeFieldOutline();
        buildCollegeParkOutline();
        buildFolklifeOutline();
        buildHuntHaughtOutline();
        buildLibraryOutline();
        buildETOutline();
        buildWallmanOutline();
        buildFalconCenterOutline();
        buildTurleyOutline();
        buildEducationOutline();
        buildColebankOutline();
        buildAlumniCenterOutline();
        buildWesleyOutline();
        makeRoutingLines();
    }
    //==================================================================================================
//Draws the lines for directions from building to building
    void makeRoutingLines()
    {
        lineArray = new Vector();
        falconCenterToSchoolHouse = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(schoolHouseCenter)
                .add(new LatLng(39.48258119869593, -80.15914309769869))
                .add(new LatLng(39.48278097048923, -80.15905056148767))
                .add(new LatLng(39.482989539909866, -80.15905726701021))
                .add(new LatLng(39.48297893031424, -80.15942506492138))
                .add(new LatLng(39.48294192610219, -80.15941668301821))
                .add(new LatLng(39.48294037347748, -80.1595313474536))
                .add(new LatLng(39.483000408274435, -80.15965305268764))
                .add(new LatLng(39.48305242113851, -80.16078762710094))
                .add(new LatLng(39.48323899432599, -80.16085535287857))
                .add(new LatLng(39.48339580857354, -80.160639770329))
                .add(new LatLng(39.48371901042052, -80.16078930348158))
                .add(falconCenterCenter));
        falconCenterToSchoolHouse .setVisible(false);

        falconCenterToHardway = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(hardwayCenter)
                .add(new LatLng(39.483017487129615, -80.16021128743887))
                .add(new LatLng(39.48305242113851, -80.16078762710094))
                .add(new LatLng(39.48323899432599, -80.16085535287857))
                .add(new LatLng(39.48339580857354, -80.160639770329))
                .add(new LatLng(39.48371901042052, -80.16078930348158))
                .add(falconCenterCenter));
        falconCenterToHardway .setVisible(false);

        falconCenterToParkingGarage = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(parkingGarageCenter)
                .add(new LatLng(39.48389290222592, -80.15969328582287))
                .add(new LatLng(39.48390584058692, -80.15978783369064))
                .add(new LatLng(39.483939480314255, -80.15988305211067))
                .add(new LatLng(39.483915156205356, -80.16004431992769))
                .add(new LatLng(39.48389807757061, -80.16048353165388))
                .add(new LatLng(39.48388643304451, -80.16056969761848))
                .add(falconCenterCenter));
        falconCenterToParkingGarage .setVisible(false);

        falconCenterToBryant = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(bryantCenter)
                .add(new LatLng(39.484553531862204, -80.15946295112371))
                .add(new LatLng(39.48436075182949, -80.15979118645191))
                .add(new LatLng(39.48408697738815,-80.15968423336744))
                .add(new LatLng(39.48389290222592, -80.15969328582287))
                .add(new LatLng(39.48390584058692, -80.15978783369064))
                .add(new LatLng(39.483939480314255, -80.15988305211067))
                .add(new LatLng(39.483915156205356, -80.16004431992769))
                .add(new LatLng(39.48389807757061, -80.16048353165388))
                .add(new LatLng(39.48388643304451, -80.16056969761848))
                .add(falconCenterCenter));
        falconCenterToBryant .setVisible(false);

        falconCenterToNewman = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(newmanCenter)
                .add(new LatLng(39.48522398819066, -80.1588212326169))
                .add(new LatLng(39.48501982444319, -80.15894260257483))
                .add(new LatLng(39.48472586899611,-80.1590545848012))
                .add(new LatLng(39.48408775368774, -80.15888761729002))
                .add(new LatLng(39.484019698059925, -80.15909984707832))
                .add(new LatLng(39.484018404226056, -80.15916857868433))
                .add(new LatLng(39.483949054695216, -80.15922624617815))
                .add(new LatLng(39.483942844286105, -80.15957996249199))
                .add(new LatLng(39.483913862369526, -80.15958935022354))
                .add(new LatLng(39.48389290222592, -80.15969328582287))
                .add(new LatLng(39.48390584058692, -80.15978783369064))
                .add(new LatLng(39.483939480314255, -80.15988305211067))
                .add(new LatLng(39.483915156205356, -80.16004431992769))
                .add(new LatLng(39.48389807757061, -80.16048353165388))
                .add(new LatLng(39.48388643304451, -80.16056969761848))
                .add(falconCenterCenter));
        falconCenterToNewman .setVisible(false);

        falconCenterToJaynes = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(jaynesCenter)
                .add(new LatLng(39.48356374951255, -80.16010634601116))
                .add(new LatLng(39.48390609935413, -80.16009762883186))
                .add(new LatLng(39.48389807757061, -80.16048353165388))
                .add(new LatLng(39.48388643304451, -80.16056969761848))
                .add(falconCenterCenter));
        falconCenterToJaynes .setVisible(false);

        falconCenterToMorrow = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(morrowCenter)
                .add(new LatLng(39.484319608102304, -80.15990618616343))
                .add(new LatLng(39.48423162772351, -80.15988070517778))
                .add(new LatLng(39.484209632611396, -80.15990283340216))
                .add(new LatLng(39.4839656157835, -80.15981834381819))
                .add(new LatLng(39.483923436754026, -80.15978381037712))
                .add(new LatLng(39.48394025661547, -80.15992093831301))
                .add(new LatLng(39.48389807757061, -80.16048353165388))
                .add(new LatLng(39.48388643304451, -80.16056969761848))
                .add(falconCenterCenter));
        falconCenterToMorrow .setVisible(false);

        falconCenterToPrichard = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(prichardCenter)
                .add(new LatLng(39.48518517383615 , -80.16062501817942))
                .add(new LatLng(39.48486715407558, -80.16031991690397))
                .add(new LatLng( 39.48472224629799, -80.16033634543419))
                .add(new LatLng(39.48458173721816, -80.16043424606323))
                .add(new LatLng(39.48453153685192, -80.16046643257141))
                .add(new LatLng(39.48448237150968, -80.16052812337875))
                .add(new LatLng(39.48448211274461, -80.16061663627625))
                .add(new LatLng(39.484498932470935, -80.16065184026957))
                .add(falconCenterCenter));
        falconCenterToPrichard .setVisible(false);

        falconCenterToPence = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(penceCenter)
                .add(new LatLng(39.48512332958652, -80.16184911131859))
                .add(new LatLng(39.485159297587764, -80.16148902475834))
                .add(new LatLng(39.48502499970404, -80.1614548265934))
                .add(new LatLng(39.48493624392754, -80.16146287322044))
                .add(new LatLng(39.48480272190461, -80.16135793179274))
                .add(new LatLng(39.484709825617294, -80.1613237336278))
                .add(new LatLng(39.48462236326122, -80.16130797564983))
                .add(new LatLng(39.48446762190021, -80.16138173639774))
                .add(falconCenterCenter));
        falconCenterToPence .setVisible(false);

        falconCenterToShaw = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(shawCenter)
                .add(new LatLng(39.484693005941956, -80.16250591725111))
                .add(new LatLng(39.48464642835831, -80.16225378960371))
                .add(new LatLng(39.48419462417798, -80.16235169023275))
                .add(new LatLng(39.48403315393079, -80.1623386144638))
                .add(new LatLng(39.483990716175384, -80.16220182180405))
                .add(new LatLng(39.48424094329828, -80.16187727451324))
                .add(new LatLng(39.48428881498238, -80.16164157539606))
                .add(new LatLng(39.48430951624097, -80.16150746494532))
                .add(falconCenterCenter));
        falconCenterToShaw .setVisible(false);

        falconCenterToFeasterCenter = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(feasterCenterCenter)
                .add(new LatLng(39.48656928033, -80.16280431300402))
                .add(new LatLng(39.48660731764055, -80.16280431300402))
                .add(new LatLng(39.486605765097664, -80.16295854002237))
                .add(new LatLng(39.4865058847662, -80.16307655721903))
                .add(new LatLng(39.48641195572253, -80.16311176121235))
                .add(new LatLng(39.48605357514803, -80.16304973512888))
                .add(new LatLng(39.486078674786306, -80.16279894858599))
                .add(new LatLng(39.485985262684515, -80.16273122280836))
                .add(new LatLng(39.48602692294488, -80.1626531034708))
                .add(new LatLng(39.485723656379896, -80.16255956143141))
                .add(new LatLng(39.48528427977838, -80.16247171908617))
                .add(new LatLng(39.48512332958652, -80.16184911131859))
                .add(new LatLng(39.485159297587764, -80.16148902475834))
                .add(new LatLng(39.48502499970404, -80.1614548265934))
                .add(new LatLng(39.48493624392754, -80.16146287322044))
                .add(new LatLng(39.48480272190461, -80.16135793179274))
                .add(new LatLng(39.484709825617294, -80.1613237336278))
                .add(new LatLng(39.48462236326122, -80.16130797564983))
                .add(new LatLng(39.48446762190021, -80.16138173639774))
                .add(falconCenterCenter));
        falconCenterToFeasterCenter .setVisible(false);

        falconCenterToDuvall = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(duvallCenter)
                .add(new LatLng(39.48694111355494, -80.16324453055859))
                .add(new LatLng(39.48641195572253, -80.16311176121235))
                .add(new LatLng(39.48605357514803, -80.16304973512888))
                .add(new LatLng(39.486078674786306, -80.16279894858599))
                .add(new LatLng(39.485985262684515, -80.16273122280836))
                .add(new LatLng(39.48602692294488, -80.1626531034708))
                .add(new LatLng(39.485723656379896, -80.16255956143141))
                .add(new LatLng(39.48528427977838, -80.16247171908617))
                .add(new LatLng(39.48512332958652, -80.16184911131859))
                .add(new LatLng(39.485159297587764, -80.16148902475834))
                .add(new LatLng(39.48502499970404, -80.1614548265934))
                .add(new LatLng(39.48493624392754, -80.16146287322044))
                .add(new LatLng(39.48480272190461, -80.16135793179274))
                .add(new LatLng(39.484709825617294, -80.1613237336278))
                .add(new LatLng(39.48462236326122, -80.16130797564983))
                .add(new LatLng(39.48446762190021, -80.16138173639774))
                .add(falconCenterCenter));
        falconCenterToDuvall .setVisible(false);


        falconCenterToPhysicalPlant = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(physicalPlantCenter)

                .add(new LatLng(39.488591439112305, -80.16244925558567))
                .add(new LatLng(39.488088945261524, -80.16232017427683))
                .add(new LatLng(39.48751632554546, -80.16229536384344))
                .add(new LatLng(39.4870989544759, -80.1621438190341))
                .add(new LatLng(39.48693593843674, -80.16234531998634))
                .add(new LatLng(39.48663785097681, -80.1623248681426))
                .add(new LatLng(39.48659282723899, -80.16299474984407))
                .add(new LatLng(39.48641195572253, -80.16311176121235))
                .add(new LatLng(39.48605357514803, -80.16304973512888))
                .add(new LatLng(39.486078674786306, -80.16279894858599))
                .add(new LatLng(39.485985262684515, -80.16273122280836))
                .add(new LatLng(39.48602692294488, -80.1626531034708))
                .add(new LatLng(39.485723656379896, -80.16255956143141))
                .add(new LatLng(39.48528427977838, -80.16247171908617))
                .add(new LatLng(39.48512332958652, -80.16184911131859))
                .add(new LatLng(39.485159297587764, -80.16148902475834))
                .add(new LatLng(39.48502499970404, -80.1614548265934))
                .add(new LatLng(39.48493624392754, -80.16146287322044))
                .add(new LatLng(39.48480272190461, -80.16135793179274))
                .add(new LatLng(39.484709825617294, -80.1613237336278))
                .add(new LatLng(39.48462236326122, -80.16130797564983))
                .add(new LatLng(39.48446762190021, -80.16138173639774))
                .add(falconCenterCenter));
        falconCenterToPhysicalPlant .setVisible(false);

        falconCenterToTennisCourts = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(tennisCourtCenter)
                .add(new LatLng(39.48822039096559, -80.16476567834616))
                .add(new LatLng(39.48839375401419, -80.16480792313814))
                .add(new LatLng(39.4882266009927, -80.16453500837088))
                .add(new LatLng(39.48817303949057, -80.16439720988274))
                .add(new LatLng(39.48816191318304, -80.164017342031))
                .add(new LatLng(39.48820900591441, -80.16386546194553))
                .add(new LatLng(39.48771711817434, -80.16383931040764))
                .add(new LatLng(39.48727594288569, -80.16351275146008))
                .add(new LatLng(39.48719055379685, -80.16328878700733))
                .add(new LatLng(39.48694111355494, -80.16324453055859))
                .add(new LatLng(39.48641195572253, -80.16311176121235))
                .add(new LatLng(39.48605357514803, -80.16304973512888))
                .add(new LatLng(39.486078674786306, -80.16279894858599))
                .add(new LatLng(39.485985262684515, -80.16273122280836))
                .add(new LatLng(39.48602692294488, -80.1626531034708))
                .add(new LatLng(39.485723656379896, -80.16255956143141))
                .add(new LatLng(39.48528427977838, -80.16247171908617))
                .add(new LatLng(39.48512332958652, -80.16184911131859))
                .add(new LatLng(39.485159297587764, -80.16148902475834))
                .add(new LatLng(39.48502499970404, -80.1614548265934))
                .add(new LatLng(39.48493624392754, -80.16146287322044))
                .add(new LatLng(39.48480272190461, -80.16135793179274))
                .add(new LatLng(39.484709825617294, -80.1613237336278))
                .add(new LatLng(39.48462236326122, -80.16130797564983))
                .add(new LatLng(39.48446762190021, -80.16138173639774))
                .add(falconCenterCenter));
        falconCenterToTennisCourts .setVisible(false);

        falconCenterToPracticeField = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(practiceFieldCenter)
                .add(new LatLng(39.48547188202381, -80.1637290045619))
                .add(new LatLng(39.485497499394604, -80.16341719776392))
                .add(new LatLng(39.48546696555762, -80.16334410756826))
                .add(new LatLng(39.48555856702833, -80.16310505568981))
                .add(new LatLng(39.484358164174395, -80.16335651278496))
                .add(new LatLng(39.483677866313656, -80.16327604651451))
                .add(new LatLng(39.4834628297365, -80.16286600381136))
                .add(new LatLng(39.48359609556364, -80.16232721507549))
                .add(new LatLng(39.48402953119656, -80.16210794448853))
                .add(new LatLng(39.48426035074176, -80.16187660396099))
                .add(new LatLng(39.48429709548654 , -80.16150210052729))
                .add(falconCenterCenter));
        falconCenterToPracticeField .setVisible(false);

        falconCenterToCollegePark = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(collegeParkCenter)
                .add(new LatLng(39.485345865123016, -80.16402840614319))
                .add(new LatLng(39.48547188202381, -80.1637290045619))
                .add(new LatLng(39.485497499394604, -80.16341719776392))
                .add(new LatLng(39.48546696555762, -80.16334410756826))
                .add(new LatLng(39.48555856702833, -80.16310505568981))
                .add(new LatLng(39.484358164174395, -80.16335651278496))
                .add(new LatLng(39.483677866313656, -80.16327604651451))
                .add(new LatLng(39.4834628297365, -80.16286600381136))
                .add(new LatLng(39.48359609556364, -80.16232721507549))
                .add(new LatLng(39.48402953119656, -80.16210794448853))
                .add(new LatLng(39.48426035074176, -80.16187660396099))
                .add(new LatLng(39.48429709548654 , -80.16150210052729))
                .add(falconCenterCenter));
        falconCenterToCollegePark .setVisible(false);

        falconCenterToFolklife = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(folklifeCenter)
                .add(new LatLng(39.48346593496257, -80.16444649547338))
                .add(new LatLng(39.48307105260275, -80.16428455710411))
                .add(new LatLng(39.48260448818324, -80.16405690461397))
                .add(new LatLng(39.4826321767858, -80.16386613249779))
                .add(new LatLng(39.48268910658818, -80.16379740089178))
                .add(new LatLng(39.48295227693271, -80.1633508130908))
                .add(new LatLng(39.4828166809307, -80.16320932656527))
                .add(new LatLng(39.482738014426666, -80.16298267990351))

                .add(new LatLng(39.48276492666173, -80.16274027526379))
                .add(new LatLng(39.48274784774455, -80.16204625368118))
                .add(new LatLng(39.483109091826755, -80.16118861734867))
                .add(new LatLng(39.48313031097667, -80.16086842864752))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToFolklife .setVisible(false);


        falconCenterToHuntHaught = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(huntHaughtCenter)
                .add(new LatLng(39.48319784993516, -80.16341015696526))
                .add(new LatLng(39.483199920093774, -80.16328878700733))
                .add(new LatLng(39.48314506086977, -80.16309835016727))
                .add(new LatLng(39.48296366284451, -80.16284991055727))
                .add(new LatLng(39.48276492666173, -80.16274027526379))
                .add(new LatLng(39.48274784774455, -80.16204625368118))
                .add(new LatLng(39.483109091826755, -80.16118861734867))
                .add(new LatLng(39.48313031097667, -80.16086842864752))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToHuntHaught .setVisible(false);

        falconCenterToLibrary = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(libraryCenter)
                .add(new LatLng(39.48295564095229, -80.16186688095331))
                .add(new LatLng(39.48296754440492, -80.16160972416401))
                .add(new LatLng(39.48313160482708, -80.16110815107822))
                .add(new LatLng(39.48314247316944, -80.16086507588625))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToLibrary.setVisible(false);

        falconCenterToET = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(ETCenter)
                .add(new LatLng(39.482757422289545, -80.16258805990219))
                .add(new LatLng(39.48274784774455, -80.16204625368118))
                .add(new LatLng(39.483109091826755, -80.16118861734867))
                .add(new LatLng(39.48313031097667, -80.16086842864752))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToET.setVisible(false);

        falconCenterToWallman = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(wallmanCenter)
                .add(new LatLng(39.48273594425431, -80.16211934387684))
                .add(new LatLng(39.48274784774455, -80.16204625368118))
                .add(new LatLng(39.483109091826755, -80.16118861734867))
                .add(new LatLng(39.48313031097667, -80.16086842864752))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToWallman.setVisible(false);

        falconCenterToTurley = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(turleyCenter)
                .add(new LatLng(39.48302654409657, -80.16136664897203))
                .add(new LatLng(39.483109091826755, -80.16118861734867))
                .add(new LatLng(39.48313031097667, -80.16086842864752))
                .add(new LatLng(39.483206130569215, -80.16086507588625))
                .add(new LatLng(39.4834198740951, -80.16066826879978))
                .add(new LatLng(39.48367683124147, -80.16076851636171))
                .add(falconCenterCenter));
        falconCenterToTurley .setVisible(false);

        falconCenterToEducation = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(educationCenter)
                .add(new LatLng(39.48332801103797, -80.16158256679773))
                .add(new LatLng(39.4833430196584, -80.16134083271027))
                .add(new LatLng(39.48325193280864, -80.16123689711094))
                .add(new LatLng(39.483243910949675, -80.16086608171463))
                .add(new LatLng(39.4833893393459, -80.1607172191143))
                .add(new LatLng(39.48346489988723, -80.16067564487457))
                .add(new LatLng(39.48373169004603, -80.16079634428024))
                .add(falconCenterCenter));
        falconCenterToEducation.setVisible(false);

        falconCenterToColebank = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(colebankCenter)
                .add(new LatLng(39.483243910949675, -80.16086608171463))
                .add(new LatLng(39.4833893393459, -80.1607172191143))
                .add(new LatLng(39.48346489988723, -80.16067564487457))
                .add(new LatLng(39.48373169004603, -80.16079634428024))
                .add(falconCenterCenter));
        falconCenterToColebank.setVisible(false);

        falconCenterToAlumniCenter = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(alumniCenterCenter)
                .add(new LatLng(39.481729833195004, -80.16244992613792))
                .add(new LatLng(39.48184757585333, -80.1620214432478))
                .add(new LatLng(39.48191951522563, -80.16161777079105))
                .add(new LatLng(39.48193452415002, -80.16146220266819))
                .add(new LatLng(39.48208590708576, -80.16135860234499))
                .add(new LatLng(39.48224634676055, -80.16113296151161))
                .add(new LatLng(39.48239358865251, -80.16097068786621))
                .add(new LatLng(39.48246423359722, -80.16092542558908))
                .add(new LatLng(39.48264226889053, -80.16099449247122))
                .add(new LatLng(39.483118925092164, -80.16109608113766))
                .add(new LatLng(39.48312591188515, -80.16088485717773))
                .add(new LatLng(39.483243910949675, -80.16086608171463))
                .add(new LatLng(39.4833893393459, -80.1607172191143))
                .add(new LatLng(39.48346489988723, -80.16067564487457))
                .add(new LatLng(39.48373169004603, -80.16079634428024))
                .add(falconCenterCenter));
        falconCenterToAlumniCenter.setVisible(false);

        falconCenterToWesley = map.addPolyline(new PolylineOptions()
                .color(Color.BLUE)
                .add(wesleyCenter)
                .add(new LatLng(39.48182143958817, -80.16209688037634))
                .add(new LatLng(39.48184757585333, -80.1620214432478))
                .add(new LatLng(39.48191951522563, -80.16161777079105))
                .add(new LatLng(39.48193452415002, -80.16146220266819))
                .add(new LatLng(39.48208590708576, -80.16135860234499))
                .add(new LatLng(39.48224634676055, -80.16113296151161))
                .add(new LatLng(39.48239358865251, -80.16097068786621))
                .add(new LatLng(39.48246423359722, -80.16092542558908))
                .add(new LatLng(39.48264226889053, -80.16099449247122))
                .add(new LatLng(39.483118925092164, -80.16109608113766))
                .add(new LatLng(39.48312591188515, -80.16088485717773))
                .add(new LatLng(39.483243910949675, -80.16086608171463))
                .add(new LatLng(39.4833893393459, -80.1607172191143))
                .add(new LatLng(39.48346489988723, -80.16067564487457))
                .add(new LatLng(39.48373169004603, -80.16079634428024))
                .add(falconCenterCenter));
        falconCenterToWesley.setVisible(false);

        lineArray.add(falconCenterToSchoolHouse);
        lineArray.add(falconCenterToHardway);
        lineArray.add(falconCenterToParkingGarage);
        lineArray.add(falconCenterToBryant);
        lineArray.add(falconCenterToNewman);
        lineArray.add(falconCenterToJaynes);
        lineArray.add(falconCenterToMorrow);
        lineArray.add(falconCenterToPrichard);
        lineArray.add(falconCenterToPence);
        lineArray.add(falconCenterToShaw);
        lineArray.add(falconCenterToFeasterCenter);
        lineArray.add(falconCenterToDuvall);
        lineArray.add(falconCenterToPhysicalPlant);
        lineArray.add(falconCenterToTennisCourts);
        lineArray.add(falconCenterToPracticeField);
        lineArray.add(falconCenterToCollegePark);
        lineArray.add(falconCenterToFolklife);
        lineArray.add(falconCenterToHuntHaught);
        lineArray.add(falconCenterToLibrary);
        lineArray.add(falconCenterToET);
        lineArray.add(falconCenterToWallman);
        lineArray.add(falconCenterToTurley);
        lineArray.add(falconCenterToEducation);
        lineArray.add(falconCenterToColebank);
        lineArray.add(falconCenterToAlumniCenter);
        lineArray.add(falconCenterToWesley);
    }
    //==================================================================================================
//Makes the line to be drawn around campus
    void makeCampusBoundaryLines()
    {
        fairmont = new LatLng(39.48446503424911, -80.1616569980979);
        campusOutline = new PolylineOptions();
        campusBoundaryLines = new LatLng[numBoundaryLines];
        campusBoundaryLines[0]= new LatLng(39.4807925427706, -80.16272149980068);                   //*********************************************
        campusBoundaryLines[1]=new LatLng(39.48247975994908, -80.1645940169692);                    //Markers for drawing campus boundary line
        campusBoundaryLines[2]=  new LatLng(39.48386055631289, -80.16536548733711);
        campusBoundaryLines[3]=new LatLng(39.486224873530304, -80.1653939858079);
        campusBoundaryLines[4]=new LatLng(39.48952344950378, -80.16800712794065);
        campusBoundaryLines[5]=new LatLng(39.49013719300056, -80.1649259403348);
        campusBoundaryLines[6]=new LatLng(39.48966058490349, -80.16162246465683);
        campusBoundaryLines[7]=new LatLng(39.48692325939544, -80.16087379306555);
        campusBoundaryLines[8]=new LatLng(39.48534198369535, -80.15879675745964);
        campusBoundaryLines[9]=new LatLng(39.48366932696768, -80.15828378498554);
        campusBoundaryLines[10]=new LatLng(39.481732938498425, -80.15862811356783);
        campusBoundaryLines[11]=new LatLng(39.481414385398274, -80.1597797870636);
        campusBoundaryLines[12]=new LatLng(39.4807925427706, -80.16272149980068);                   //*********************************************
        for(int n = 0; n < numBoundaryLines; n++)
            campusOutline.add(campusBoundaryLines[n]);
    }
    //==================================================================================================
//"Draws" line around Schoolhouse and sets other information about Schoolhouse
    void buildSchoolHouseOutline()
    {
        schoolHouseCoordinates = new LatLng[4];
        schoolHouseCoordinates[0] = new LatLng(39.482623896083396, -80.15930101275444);
        schoolHouseCoordinates[1] = new LatLng(39.482526856528516, -80.15929028391838);
        schoolHouseCoordinates[2] = new LatLng(39.48252608021153, -80.15920344740152);
        schoolHouseCoordinates[3] = new LatLng(39.48262079081972, -80.15920210629702);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(schoolHouseCoordinates[n]);
        schoolHouse = map.addPolygon(temp);
        schoolHouse.setFillColor(Color.TRANSPARENT);
        schoolHouse.setStrokeColor(Color.TRANSPARENT);
        schoolHouse.setClickable(true);
        schoolHouseCenter = new LatLng(39.482580422379556, -80.15925139188766);
        schoolHouseMarker = map.addMarker(new MarkerOptions()
                        .position(schoolHouseCenter)
                        .title("One Room Schoolhouse Museum")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        schoolHouseInfo = new Vector[6];
        schoolHouseInfo[0] = new Vector<String>();
        schoolHouseInfo[1] = new Vector<String>();
        schoolHouseInfo[2] = new Vector<String>();
        schoolHouseInfo[3] = new Vector<String>();
        schoolHouseInfo[4] = new Vector<String>();
        schoolHouseInfo[5] = new Vector<String>();
        schoolHouseInfo[0].add("One Room Schoolhouse Museum");
        schoolHouseInfo[1].add("With roots reaching back to the creation of the first private normal school in West Virginia in 1865, " +
                "Fairmont State University has a long history of providing high quality training for the state’s educators. The One-Room " +
                "Schoolhouse, a Fairmont State University campus landmark, remains a visible symbol of the University’s continued focus on " +
                "teaching and learning. Located near the Bryant Street Entrance to main campus, the museum is a significant artifact of regional and educational history.");
        schoolHouseInfo[2].add("N/A");
        schoolHouseInfo[3].add("No events at this time");
        schoolHouseInfo[4].add("N/A");
        schoolHouseInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Hardway and sets other information about Hardway
    void buildHardwayOutline()
    {
        hardwayCoordinates = new LatLng[8];
        hardwayCoordinates[0] = new LatLng(39.483015158195066, -80.16078528016806);
        hardwayCoordinates[1] = new LatLng(39.48283867648333, -80.16079567372799);
        hardwayCoordinates[2] = new LatLng(39.48279520291376, -80.16038462519646);
        hardwayCoordinates[3] = new LatLng(39.48264123380293, -80.16038026660681);
        hardwayCoordinates[4] = new LatLng(39.48263347064547, -80.16011238098145);
        hardwayCoordinates[5] = new LatLng(39.48276906700466, -80.16011238098145);
        hardwayCoordinates[6] = new LatLng(39.48279313274311, -80.15961550176144);
        hardwayCoordinates[7] = new LatLng(39.48297297858915, -80.15962053090334);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 8; n++)
            temp.add(hardwayCoordinates[n]);
        hardway = map.addPolygon(temp);
        hardway.setFillColor(Color.TRANSPARENT);
        hardway.setStrokeColor(Color.TRANSPARENT);
        hardway.setClickable(true);
        hardwayCenter = new LatLng(39.48290414555767, -80.16020189970732);
        hardwayMarker = map.addMarker(new MarkerOptions()
                        .position(hardwayCenter)
                        .title("Hardway Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        hardwayInfo = new Vector[6];
        hardwayInfo[0] = new Vector<String>();
        hardwayInfo[1] = new Vector<String>();
        hardwayInfo[2] = new Vector<String>();
        hardwayInfo[3] = new Vector<String>();
        hardwayInfo[4] = new Vector<String>();
        hardwayInfo[5] = new Vector<String>();
        hardwayInfo[0].add("Hardway Hall");
        hardwayInfo[1].add("Fairmont State has occupied its present location in Fairmont since 1917," +
                " when its administration building, Hardway Hall, was opened. The west wing was added in 1923. " +
                "The building was referred to as the Administration Building until 1989 when it was renamed for longtime President, " +
                "Wendell G. Hardway. Today, Hardway Hall houses various administrative offices, including the President's Office, Business/Accounts Payable, " +
                "Graduate Studies, and Institutional Research. It is also home to the College of Liberal Arts' Department of Social Sciences and Department of " +
                "Behavioral Sciences, including our Master of Criminal Justice program. These are two of the largest departments on campus.\n");
        hardwayInfo[2].add("Criminal Justice –Undergraduate");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/criminal-justice-program");
        hardwayInfo[2].add("Criminal Justice –Graduate ");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/criminal-justice-graduate-program");
        hardwayInfo[2].add("History");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/history-program");
        hardwayInfo[2].add("National Security and Intelligence");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/national-security-and-intelligence-program");
        hardwayInfo[2].add("Political Science");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/political-science-program");
        hardwayInfo[2].add("Psychology");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/psychology-program");
        hardwayInfo[2].add("Sociology");
        hardwayInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/sociology-program");
        hardwayInfo[3].add("No events at this time");
        hardwayInfo[4].add("Department of Behavioral Sciences");
        hardwayInfo[4].add(" ");
        hardwayInfo[4].add("Department of Social Sciences");
        hardwayInfo[4].add(" ");
        hardwayInfo[4].add("Master of Criminal Justice Program");
        hardwayInfo[4].add(" ");
        hardwayInfo[5].add("N/A");

    }
    //==================================================================================================
//"Draws" line around Parking garage and sets other information about parking garage
    void buildParkingGarageOutline()
    {
        parkingGarageCoordinates = new LatLng[4];
        parkingGarageCoordinates[0] = new LatLng(39.4838978188034, -80.15953671187162);
        parkingGarageCoordinates[1] = new LatLng(39.483060184249226, -80.15950821340084);
        parkingGarageCoordinates[2] = new LatLng(39.48305759654574, -80.15878401696682);
        parkingGarageCoordinates[3] = new LatLng(39.48390765195727, -80.15882156789303);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(parkingGarageCoordinates[n]);
        parkingGarage = map.addPolygon(temp);
        parkingGarage.setFillColor(Color.TRANSPARENT);
        parkingGarage.setStrokeColor(Color.TRANSPARENT);
        parkingGarage.setClickable(true);
        parkingGarageCenter = new LatLng(39.48345506667074, -80.15912733972073);
        parkingGarageMarker = map.addMarker(new MarkerOptions()
                        .position(parkingGarageCenter)
                        .title("Parking Garage")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        parkingGarageInfo = new Vector[6];
        parkingGarageInfo[0] = new Vector<String>();
        parkingGarageInfo[1] = new Vector<String>();
        parkingGarageInfo[2] = new Vector<String>();
        parkingGarageInfo[3] = new Vector<String>();
        parkingGarageInfo[4] = new Vector<String>();
        parkingGarageInfo[5] = new Vector<String>();
        parkingGarageInfo[0].add("Parking Garage");
        parkingGarageInfo[1].add("The Parking Garage is available to students, faculty and staff, and visitors. " +
                "Students and visitors may be directed to enter the parking garage from the Bryant Street entrance " +
                "and park anywhere on levels 1 -5. Questions concerning traffic or parking regulations should be " +
                "directed to the Campus Police at (304) 367-4157");
        parkingGarageInfo[2].add("N/A");
        parkingGarageInfo[3].add("No events at this time");
        parkingGarageInfo[4].add("Department of Public Safety");
        parkingGarageInfo[4].add("https://www.fairmontstate.edu/campuspolice/about-us");
        parkingGarageInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Bryant and sets other information about Bryant
    void buildBryantOutline()
    {
        bryantCoordinates = new LatLng[6];
        bryantCoordinates[0] = new LatLng(39.48492434081187, -80.15979923307896);
        bryantCoordinates[1] = new LatLng(39.48456802268871, -80.15944585204124);
        bryantCoordinates[2] = new LatLng(39.484080508224814, -80.15925776213408);
        bryantCoordinates[3] = new LatLng(39.48410638487461, -80.15900027006865);
        bryantCoordinates[4] = new LatLng(39.48458458362959, -80.15911761671305);
        bryantCoordinates[5] = new LatLng(39.48504337187684, -80.15963762998581);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 6; n++)
            temp.add(bryantCoordinates[n]);
        bryant = map.addPolygon(temp);
        bryant.setFillColor(Color.TRANSPARENT);
        bryant.setStrokeColor(Color.TRANSPARENT);
        bryant.setClickable(true);
        bryantCenter = new LatLng(39.484580702159434, -80.15932314097881);
        bryantMarker = map.addMarker(new MarkerOptions()
                        .position(bryantCenter)
                        .title("Bryant Place")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        bryantInfo = new Vector[6];
        bryantInfo[0] = new Vector<String>();
        bryantInfo[1] = new Vector<String>();
        bryantInfo[2] = new Vector<String>();
        bryantInfo[3] = new Vector<String>();
        bryantInfo[4] = new Vector<String>();
        bryantInfo[5] = new Vector<String>();
        bryantInfo[0].add("Bryant Place");
        bryantInfo[1].add("Fully completed in 2005, Bryant Place houses more than 470 students. The building has a total of 110,000 square feet and features 100 suites " +
                "with a combination of double/triple and single bedrooms. Each suite has restroom facilities and a shower plus a combination of loft or captain bed with " +
                "furniture including wardrobes, desks and additional dresser storage. Wireless Internet, basic cable up to 70 channels, and laundry facilities are free " +
                "amenities provided to all residential students. A study lounge and kitchen facility is also available on each of the floors. The top floor features " +
                "classrooms, a computer lab, research lab and office/storage space.\n");
        bryantInfo[2].add("N/A");
        bryantInfo[3].add("No events at this time");
        bryantInfo[4].add("Residence Life");
        bryantInfo[4].add("https://www.fairmontstate.edu/stulife/residence-life/bryant-place");
        bryantInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Newman and sets other information about Newman
    void buildNewmanOutline()
    {
        newmanCoordinates = new LatLng[4];
        newmanCoordinates[0] = new LatLng(39.48512798731436, -80.15918802469969);
        newmanCoordinates[1] = new LatLng(39.48509486568747, -80.15904452651739);
        newmanCoordinates[2] = new LatLng(39.48534327750458, -80.15890203416348);
        newmanCoordinates[3] = new LatLng(39.485379762915485, -80.15905760228634);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(newmanCoordinates[n]);
        newman = map.addPolygon(temp);
        newman.setFillColor(Color.TRANSPARENT);
        newman.setStrokeColor(Color.TRANSPARENT);
        newman.setClickable(true);
        newmanCenter = new LatLng(39.48522864591175, -80.15907470136881);
        newmanMarker = map.addMarker(new MarkerOptions()
                        .position(newmanCenter)
                        .title("Newman Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        newmanInfo = new Vector[6];
        newmanInfo[0] = new Vector<String>();
        newmanInfo[1] = new Vector<String>();
        newmanInfo[2] = new Vector<String>();
        newmanInfo[3] = new Vector<String>();
        newmanInfo[4] = new Vector<String>();
        newmanInfo[5] = new Vector<String>();
        newmanInfo[0].add("Newman Center");
        newmanInfo[1].add("The campus Roman Catholic Community gathers at the Newman Center, " +
                "which is located directly across the street from the entrance to Bryant Street Dormitory. " +
                "The Newman Center is a full service campus ministry organization available to all " +
                "administrators, faculty, staff and students. Contact the Newman Center at (304) 363-2300.");
        newmanInfo[2].add("N/A");
        newmanInfo[3].add("No events at this time");
        newmanInfo[4].add("N/A");
        newmanInfo[5].add("- Weekend Services:\n      SATURDAY EVENING\n          7:00 pm\n      SUNDAY\n         10:00 am\n         12:00 pm");
    }
    //==================================================================================================
//"Draws" line around Jaynes and sets other information about Jaynes
    void buildJaynesOutline()
    {
        jaynesCoordinates = new LatLng[4];
        jaynesCoordinates[0] = new LatLng(39.48382562270994, -80.1600268855691);
        jaynesCoordinates[1] = new LatLng(39.48326978791076, -80.16002386808395);
        jaynesCoordinates[2] = new LatLng(39.48325555558337, -80.15979554504156);
        jaynesCoordinates[3] = new LatLng(39.48381371940417, -80.15977811068296);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(jaynesCoordinates[n]);
        jaynes = map.addPolygon(temp);
        jaynes.setFillColor(Color.TRANSPARENT);
        jaynes.setStrokeColor(Color.TRANSPARENT);
        jaynes.setClickable(true);
        jaynesCenter = new LatLng(39.48355909167996, -80.15991289168596);
        jaynesMarker = map.addMarker(new MarkerOptions()
                        .position(jaynesCenter)
                        .title("Jaynes Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        jaynesInfo = new Vector[6];
        jaynesInfo[0] = new Vector<String>();
        jaynesInfo[1] = new Vector<String>();
        jaynesInfo[2] = new Vector<String>();
        jaynesInfo[3] = new Vector<String>();
        jaynesInfo[4] = new Vector<String>();
        jaynesInfo[5] = new Vector<String>();
        jaynesInfo[0].add("Jaynes Hall");
        jaynesInfo[1].add("Formerly known as the Science Hall, Jaynes Hall was completed in 1931 and was renamed for " +
                "former faculty member Edgar N. Jaynes in 1980. Today, Jaynes Hall is home to the School of Business's " +
                "graduate and undergraduate programs and the College of Liberal Arts' Department of Language and Literature." +
                " FSU's Writing Center and a state-of-the-art LearnLab are also available in this building. \n");
        jaynesInfo[2].add("Accounting");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/bs-degree-accounting");
        jaynesInfo[2].add("Business");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/business");
        jaynesInfo[2].add("Business Administration");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/bs-degree-business-administration");
        jaynesInfo[2].add("English");
        jaynesInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/english-program");
        jaynesInfo[2].add("English Education");
        jaynesInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/english-education-program");
        jaynesInfo[2].add("Finance");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/finance-program");
        jaynesInfo[2].add("French Program");
        jaynesInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/french-program");
        jaynesInfo[2].add("Information Systems Management");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/bs-degree-information-systems-management");
        jaynesInfo[2].add("Management");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/management-program");
        jaynesInfo[2].add("Marketing");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/marketing-program");
        jaynesInfo[2].add("Master of Business Administration");
        jaynesInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/mba-program");
        jaynesInfo[2].add("Spanish");
        jaynesInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/spanish-program");
        jaynesInfo[2].add("Spanish Education");
        jaynesInfo[2].add("http://www.fairmontstate.edu/collegeofliberalarts/academics/spanish-education-program");
        jaynesInfo[3].add("No events at this time");
        jaynesInfo[4].add("Department of Language and Literature");
        jaynesInfo[4].add(" ");
        jaynesInfo[4].add("Honors Program");
        jaynesInfo[4].add("https://www.fairmontstate.edu/honors/");
        jaynesInfo[4].add("School of Business");
        jaynesInfo[4].add(" ");
        jaynesInfo[4].add("Writing Center");
        jaynesInfo[4].add("https://www.fairmontstate.edu/academics/tutoring-services");
        jaynesInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Morrow and sets other information about Morrow
    void buildMorrowOutline()
    {
        morrowCoordinates = new LatLng[4];
        morrowCoordinates[0] = new LatLng(39.483937410177646, -80.16000408679247);
        morrowCoordinates[1] = new LatLng(39.483974672626964, -80.15984449535608);
        morrowCoordinates[2] = new LatLng(39.484648239709365, -80.16012009233236);
        morrowCoordinates[3] = new LatLng(39.48460968379808, -80.16030181199312);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(morrowCoordinates[n]);
        morrow = map.addPolygon(temp);
        morrow.setFillColor(Color.TRANSPARENT);
        morrow.setStrokeColor(Color.TRANSPARENT);
        morrow.setClickable(true);
        morrowCenter = new LatLng(39.48429036757699, -80.16003794968128);
        morrowMarker = map.addMarker(new MarkerOptions()
                        .position(morrowCenter)
                        .title("Morrow Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        morrowInfo = new Vector[6];
        morrowInfo[0] = new Vector<String>();
        morrowInfo[1] = new Vector<String>();
        morrowInfo[2] = new Vector<String>();
        morrowInfo[3] = new Vector<String>();
        morrowInfo[4] = new Vector<String>();
        morrowInfo[5] = new Vector<String>();
        morrowInfo[0].add("Morrow Hall");
        morrowInfo[1].add("Completed in 1922, Morrow Hall was the first women's residence hall. It was named in honor of " +
                "Nancy R. Cameron Morrow, a former acting principal and faculty member. At one time, it even housed the school " +
                "cafeteria. Today, Morrow Hall features four double occupancy rooms with bathrooms, one single room, three quad " +
                "occupancy rooms (one with a restroom) and 70 double occupancy rooms.  Wireless Internet, basic cable up to 70 " +
                "channels, and laundry facilities are free amenities provided to all residential students.\n");
        morrowInfo[2].add("N/A");
        morrowInfo[3].add("No events at this time");
        morrowInfo[4].add("Residence Life");
        morrowInfo[4].add("https://www.fairmontstate.edu/stulife/residence-life/morrow-hall");
        morrowInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Pence and sets other information about Pence
    void buildPenceOutline()
    {
        penceCoordinates = new LatLng[8];
        penceCoordinates[0] = new LatLng(39.48489846446644, -80.16215957701206);
        penceCoordinates[1] = new LatLng(39.48493443258396, -80.16186621040106);
        penceCoordinates[2] = new LatLng(39.48487931596461, -80.16184139996767);
        penceCoordinates[3] = new LatLng(39.484905451080635, -80.16168214380741);
        penceCoordinates[4] = new LatLng(39.48500611000016, -80.1616895198822);
        penceCoordinates[5] = new LatLng(39.48504751208413, -80.16143001616001);
        penceCoordinates[6] = new LatLng(39.48514144297077, -80.16147661954165);
        penceCoordinates[7] = new LatLng(39.485035091461526, -80.16221322119236);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 8; n++)
            temp.add(penceCoordinates[n]);
        pence = map.addPolygon(temp);
        pence.setFillColor(Color.TRANSPARENT);
        pence.setStrokeColor(Color.TRANSPARENT);
        pence.setClickable(true);
        penceCenter = new LatLng(39.485015942997336, -80.16182329505682);
        penceMarker = map.addMarker(new MarkerOptions()
                        .position(penceCenter)
                        .title("Pence Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        penceInfo = new Vector[6];
        penceInfo[0] = new Vector<String>();
        penceInfo[1] = new Vector<String>();
        penceInfo[2] = new Vector<String>();
        penceInfo[3] = new Vector<String>();
        penceInfo[4] = new Vector<String>();
        penceInfo[5] = new Vector<String>();
        penceInfo[0].add("Pence Hall");
        penceInfo[1].add("Pence Hall was built in 1959 and was named for former President John Pence. It was at first an " +
                "all-male residence hall but has housed both men and women since 2002. With 67 double occupancy rooms, Pence " +
                "Hall is home to many of Fairmont State's Fighting Falcon athletes. Wireless Internet, basic cable up to 70 " +
                "channels, and laundry facilities are free amenities provided to all residential students.\n");
        penceInfo[2].add("N/A");
        penceInfo[3].add("No events at this time");
        penceInfo[4].add("Residence Life");
        penceInfo[4].add("https://www.fairmontstate.edu/stulife/residence-life/pence-hall");
        penceInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Prichard and sets other information about Prichard
    void buildPrichardOutline()
    {
        prichardCoordinates = new LatLng[4];
        prichardCoordinates[0] = new LatLng(39.48480996729227, -80.16050096601248);
        prichardCoordinates[1] = new LatLng(39.484913472747955, -80.16037590801716);
        prichardCoordinates[2] = new LatLng(39.485430738954, -80.16091201454401);
        prichardCoordinates[3] = new LatLng(39.48535621559578, -80.16105886548758);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(prichardCoordinates[n]);
        prichard = map.addPolygon(temp);
        prichard.setFillColor(Color.TRANSPARENT);
        prichard.setStrokeColor(Color.TRANSPARENT);
        prichard.setClickable(true);
        prichardCenter = new LatLng(39.48510806258757, -80.16068503260612);
        prichardMarker = map.addMarker(new MarkerOptions()
                        .position(prichardCenter)
                        .title("Prichard Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        prichardInfo = new Vector[6];
        prichardInfo[0] = new Vector<String>();
        prichardInfo[1] = new Vector<String>();
        prichardInfo[2] = new Vector<String>();
        prichardInfo[3] = new Vector<String>();
        prichardInfo[4] = new Vector<String>();
        prichardInfo[5] = new Vector<String>();
        prichardInfo[0].add("Prichard Hall");
        prichardInfo[1].add("Formerly known as North Hall, this building was completed in 1964 and originally " +
                "served as an all-women residence hall. The building was renamed in 1980 for M. Dorcas Prichard. " +
                "Since 1987, the residence hall has housed both men and women and offers 75 double occupancy rooms. " +
                "Today, Prichard Hall's residents include members of the Honors Program, international students and FSU's " +
                "first live-in faculty member. With a focus on community and learning, Prichard Hall features a lobby " +
                "full of books and activities to interest any student. Wireless Internet, basic cable up to 70 channels, " +
                "and laundry facilities are free amenities provided to all residential students.\n");
        prichardInfo[2].add("N/A");
        prichardInfo[3].add("No events at this time");
        prichardInfo[4].add("Residence Life");
        prichardInfo[4].add("https://www.fairmontstate.edu/stulife/residence-life/prichard-hall");
        prichardInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Shaw and sets other information about Shaw
    void buildShawOutline()
    {
        shawCoordinates = new LatLng[4];
        shawCoordinates[0] = new LatLng(39.48446167030253, -80.16269903630018);
        shawCoordinates[1] = new LatLng(39.48434858984977, -80.16272217035294);
        shawCoordinates[2] = new LatLng(39.48431262142923, -80.16249619424343);
        shawCoordinates[3] = new LatLng(39.48444381550643, -80.16246199607849);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(shawCoordinates[n]);
        shaw = map.addPolygon(temp);
        shaw.setFillColor(Color.TRANSPARENT);
        shaw.setStrokeColor(Color.TRANSPARENT);
        shaw.setClickable(true);
        shawCenter = new LatLng(39.48439257997911, -80.16260750591755);
        shawMarker = map.addMarker(new MarkerOptions()
                        .position(shawCenter)
                        .title("Shaw House")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        shawInfo = new Vector[6];
        shawInfo[0] = new Vector<String>();
        shawInfo[1] = new Vector<String>();
        shawInfo[2] = new Vector<String>();
        shawInfo[3] = new Vector<String>();
        shawInfo[4] = new Vector<String>();
        shawInfo[5] = new Vector<String>();
        shawInfo[0].add("Shaw House");
        shawInfo[1].add(("..."));
        shawInfo[2].add("N/A");
        shawInfo[3].add("No events at this time");
        shawInfo[4].add("N/A");
        shawInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Feaster center and sets other information about Feaster center
    void buildFeasterCenterOutline()
    {
        feasterCenterCoordinates = new LatLng[4];
        feasterCenterCoordinates[0] = new LatLng(39.48585536531503, -80.16271211206913);
        feasterCenterCoordinates[1] = new LatLng(39.48591384503731, -80.16213074326515);
        feasterCenterCoordinates[2] = new LatLng(39.48660628261198, -80.16224071383476);
        feasterCenterCoordinates[3] = new LatLng(39.48653952323581, -80.16285493969917);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(feasterCenterCoordinates[n]);
        feasterCenter = map.addPolygon(temp);
        feasterCenter.setFillColor(Color.TRANSPARENT);
        feasterCenter.setStrokeColor(Color.TRANSPARENT);
        feasterCenter.setClickable(true);
        feasterCenterCenter = new LatLng(39.4862574771021, -80.16242913901806);
        feasterCenterMarker = map.addMarker(new MarkerOptions()
                        .position(feasterCenterCenter)
                        .title("Feaster Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        feasterCenterInfo = new Vector[6];
        feasterCenterInfo[0] = new Vector<String>();
        feasterCenterInfo[1] = new Vector<String>();
        feasterCenterInfo[2] = new Vector<String>();
        feasterCenterInfo[3] = new Vector<String>();
        feasterCenterInfo[4] = new Vector<String>();
        feasterCenterInfo[5] = new Vector<String>();
        feasterCenterInfo[0].add("Feaster Center");
        feasterCenterInfo[1].add("Completed in 1978, the Feaster Center was named for former " +
                "President Easton Feaster. This is the official home of Fairmont State Athletics including our basketball arena, " +
                "competition pool, video room for watching game footage, men's and women's locker rooms, and the athletic training suite. " +
                "Also, the Athletic Director and coaching staff for most teams have offices here. \n" +
                "Fairmont State is a member of the NCAA Mountain East Conference. Varsity programs for men are offered in football, " +
                "basketball, baseball, cross-country, golf, tennis and swimming. The intercollegiate athletic program for women includes " +
                "tennis, golf, basketball, volleyball, swimming, softball, soccer, acrobatics & tumbling and cross-country.\n" +
                "\n" +
                "Located in the Feaster Center on the Fairmont State campus, the pool is home to the Fighting Falcon men's and women's swim " +
                "teams. The 25-yard, six-lane pool was re-painted and received some minor renovations prior to the 2013 season. The pool also " +
                "includes a six-lane Daktronics digital readout for meets.\n" +
                "In addition to hosting numerous Fairmont State meets throughout the year, the pool has also hosted several club and high school championships.\n" +
                "\n" +
                "Home of Acrobatics & Tumbling, Men’s & Women’s Basketball, and Volleyball.\n" +
                "Joe Retton Arena was dedicated in 2000 to Joseph “Jo Jo” Retton Jr., FSU basketball coach from 1963-1982.\n" +
                "The summer of 2014 featured a $1.2 million renovation of Joe Retton Arena, including a new gym floor, seating, lighting, sound system and LED scorer's table.\n");
        feasterCenterInfo[2].add("N/A");
        feasterCenterInfo[3].add("No events at this time");
        feasterCenterInfo[4].add("Acrobatics and Tumbling");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=acro");
        feasterCenterInfo[4].add("Athletic Training");
        feasterCenterInfo[4].add("https://webfors.fairmontstate.edu/pls/prod_dad/bzpkedir.P_DeptDirectory?dir_indx=ATHLETICTRAINER&next_row=1&prev_" +
                "row=0&searchtype=D&cur_orgn=&ButtonSelected=");
        feasterCenterInfo[4].add("Baseball");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=baseball");
        feasterCenterInfo[4].add("Fighting Falcons");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx");
        feasterCenterInfo[4].add("Football");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=football");
        feasterCenterInfo[4].add("General Athletics");
        feasterCenterInfo[4].add("https://webfors.fairmontstate.edu/pls/prod_dad/bzpkedir.P_DeptDirectory?dir_indx=ATHLETICTRAINER&next_" +
                "row=1&prev_row=0&searchtype=D&cur_orgn=&ButtonSelected=");
        feasterCenterInfo[4].add("Men’s Basketball");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mbball");
        feasterCenterInfo[4].add("Men’s Cross Country");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mcross");
        feasterCenterInfo[4].add("Men’s Golf");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mgolf");
        feasterCenterInfo[4].add("Men’s Swimming");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mswim");
        feasterCenterInfo[4].add("Men’s Tennis");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mten");
        feasterCenterInfo[4].add("Softball");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=softball");
        feasterCenterInfo[4].add("Volleyball");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wvball");
        feasterCenterInfo[4].add("Women’s Basketball");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wbball");
        feasterCenterInfo[4].add("Women’s Cross Country");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wcross");
        feasterCenterInfo[4].add("Women’s Golf");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wgolf");
        feasterCenterInfo[4].add("Women’s Soccer");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wsoc");
        feasterCenterInfo[4].add("Women’s Swimming");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wswim");
        feasterCenterInfo[4].add("Women’s Tennis");
        feasterCenterInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wgolf");
        feasterCenterInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Duvall-Rosier and sets other information about Duvall-Rosier
    void buildDuvallRosierOutline()
    {
        duvallCoordinates = new LatLng[5];
        duvallCoordinates[0] = new LatLng(39.48827110617078, -80.16382556408644);
        duvallCoordinates[1] = new LatLng(39.48770340426324, -80.16379404813051);
        duvallCoordinates[2] = new LatLng(39.487246962358206, -80.16342289745808);
        duvallCoordinates[3] = new LatLng(39.48731061600094, -80.16244154423475);
        duvallCoordinates[4] = new LatLng(39.488242643560156, -80.16244154423475);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 5; n++)
            temp.add(duvallCoordinates[n]);
        duvall = map.addPolygon(temp);
        duvall.setFillColor(Color.TRANSPARENT);
        duvall.setStrokeColor(Color.TRANSPARENT);
        duvall.setClickable(true);
        duvallCenter = new LatLng(39.487848823333806, -80.163116119802);
        duvallMarker = map.addMarker(new MarkerOptions()
                        .position(duvallCenter)
                        .title("Duvall-Rosier Field")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        duvallInfo = new Vector[6];
        duvallInfo[0] = new Vector<String>();
        duvallInfo[1] = new Vector<String>();
        duvallInfo[2] = new Vector<String>();
        duvallInfo[3] = new Vector<String>();
        duvallInfo[4] = new Vector<String>();
        duvallInfo[5] = new Vector<String>();
        duvallInfo[0].add("Duvall-Rosier Football Field");
        duvallInfo[1].add("Dedicated in 1927, Duvall-Rosier Field was named for former President Joseph Rosier. In 2000, the name Duvall was added to honor Harold S. " +
                "“Deacon” Duvall, FSU football coach from 1952-1971. Duvall led the Falcons to the 1967 NAIA National Championship.\n" +
                "During the home opener of the 2014 season on September 4, 2014, a statue of Deacon Duvall was unveiled during a pregame dedication ceremony.\n" +
                "Over the last several years, field turf, a state-of-the-art video board and substantial grounds work has been added. The field also includes" +
                " a generous sized press box, president’s suite and complete lighting for night contests.\n" +
                "Home of FSU’s Football. During football season, Duvall-Rosier Field comes alive with falcon pride. The field also serves as the home for FSU " +
                "softball and the women’s soccer program\n");
        duvallInfo[2].add("N/A");
        duvallInfo[3].add("No events at this time");
        duvallInfo[4].add("Football");
        duvallInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=football");
        duvallInfo[4].add("Softball");
        duvallInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=softball");
        duvallInfo[4].add("Women’s Soccer");
        duvallInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wsoc");
        duvallInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Physical plant and sets other information about Physical plant
    void buildPhysicalPlantOutline()
    {
        physicalPlantCoordinates = new LatLng[4];
        physicalPlantCoordinates[0] = new LatLng(39.48875057003301, -80.16360126435757);
        physicalPlantCoordinates[1] = new LatLng(39.488615244086205, -80.1635942235589);
        physicalPlantCoordinates[2] = new LatLng(39.488626370321214, -80.16287539154291);
        physicalPlantCoordinates[3] = new LatLng(39.48875057003301, -80.1629002019763);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(physicalPlantCoordinates[n]);
        physicalPlant = map.addPolygon(temp);
        physicalPlant.setFillColor(Color.TRANSPARENT);
        physicalPlant.setStrokeColor(Color.TRANSPARENT);
        physicalPlant.setClickable(true);
        physicalPlantCenter = new LatLng(39.48869804393199, -80.163250900805);
        physicalPlantMarker = map.addMarker(new MarkerOptions()
                        .position(physicalPlantCenter)
                        .title("Physical Plant Building")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        physicalPlantInfo = new Vector[6];
        physicalPlantInfo[0] = new Vector<String>();
        physicalPlantInfo[1] = new Vector<String>();
        physicalPlantInfo[2] = new Vector<String>();
        physicalPlantInfo[3] = new Vector<String>();
        physicalPlantInfo[4] = new Vector<String>();
        physicalPlantInfo[5] = new Vector<String>();
        physicalPlantInfo[0].add("Physical Plant Building");
        physicalPlantInfo[1].add("The Physical Plant Department’s mission and functions relate to service support for the entire institution.  " +
                "Because of its diverse responsibilities, the Physical Plant establishes and maintains working relationships and communication with virtually all departments.\n" +
                "Its organization is unique within the institution, because it operates outside of the institution’s teaching, research and public service roles.  " +
                "Decision-making authority exists at each level of the department, from the director to individual tradesman, but all Physical Plant" +
                " employees work together to achieve unity of effort and consistency in policies and procedures.\n");
        physicalPlantInfo[2].add("N/A");
        physicalPlantInfo[3].add("No events at this time");
        physicalPlantInfo[4].add("Administrative and Fiscal Affairs");
        physicalPlantInfo[4].add("http://www.fairmontstate.edu/adminfiscalaffairs/physical-plant/physical-plant-staff");
        physicalPlantInfo[5].add("N/A");

    }
    //==================================================================================================
//"Draws" line around Tennis courts and sets other information about Tennis courts
    void buildTennisCourtsOutline()
    {
        tennisCourtCoordinates = new LatLng[4];
        tennisCourtCoordinates[0] = new LatLng(39.48851200289042, -80.16627006232738);
        tennisCourtCoordinates[1] = new LatLng(39.488180802029675, -80.16622714698315);
        tennisCourtCoordinates[2] = new LatLng(39.4882664486535, -80.16502887010574);
        tennisCourtCoordinates[3] = new LatLng(39.488594802859126, -80.16507178544998);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(tennisCourtCoordinates[n]);
        tennisCourt = map.addPolygon(temp);
        tennisCourt.setFillColor(Color.TRANSPARENT);
        tennisCourt.setStrokeColor(Color.TRANSPARENT);
        tennisCourt.setClickable(true);
        tennisCourtCenter = new LatLng(39.48838236899142, -80.16563337296247);
        tennisCourtMarker = map.addMarker(new MarkerOptions()
                        .position(tennisCourtCenter)
                        .title("Tennis Courts")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        tennisCourtInfo = new Vector[6];
        tennisCourtInfo[0] = new Vector<String>();
        tennisCourtInfo[1] = new Vector<String>();
        tennisCourtInfo[2] = new Vector<String>();
        tennisCourtInfo[3] = new Vector<String>();
        tennisCourtInfo[4] = new Vector<String>();
        tennisCourtInfo[5] = new Vector<String>();
        tennisCourtInfo[0].add("Tennis Courts");
        tennisCourtInfo[1].add("Located on campus and adjacent to Duvall-Rosier Field, Fairmont State's men's and " +
                "women's tennis teams have six courts to use for play and practice.");
        tennisCourtInfo[2].add("N/A");
        tennisCourtInfo[3].add("No events at this time");
        tennisCourtInfo[4].add("Men’s Tennis");
        tennisCourtInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=mten");
        tennisCourtInfo[4].add("Women’s Tennis");
        tennisCourtInfo[4].add("http://www.fightingfalcons.com/index.aspx?path=wten");
        tennisCourtInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Practice field and sets other information about Practice field
    void buildPracticeFieldOutline()
    {
        practiceFieldCoordinates = new LatLng[4];
        practiceFieldCoordinates[0] = new LatLng(39.48744646199482, -80.16491554677486);
        practiceFieldCoordinates[1] = new LatLng(39.486455685788954, -80.16452930867672);
        practiceFieldCoordinates[2] = new LatLng(39.48660731764055, -80.16377124935389);
        practiceFieldCoordinates[3] = new LatLng(39.48759395163052, -80.16412697732449);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(practiceFieldCoordinates[n]);
        practiceField = map.addPolygon(temp);
        practiceField.setFillColor(Color.TRANSPARENT);
        practiceField.setStrokeColor(Color.TRANSPARENT);
        practiceField.setClickable(true);
        practiceFieldCenter = new LatLng(39.48701848152654, -80.16432378441095);
        practiceFieldMarker = map.addMarker(new MarkerOptions()
                        .position(practiceFieldCenter)
                        .title("Practice Field")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        practiceFieldInfo = new Vector[6];
        practiceFieldInfo[0] = new Vector<String>();
        practiceFieldInfo[1] = new Vector<String>();
        practiceFieldInfo[2] = new Vector<String>();
        practiceFieldInfo[3] = new Vector<String>();
        practiceFieldInfo[4] = new Vector<String>();
        practiceFieldInfo[5] = new Vector<String>();
        practiceFieldInfo[0].add("Practice Field");
        practiceFieldInfo[0].add("...");
        practiceFieldInfo[2].add("N/A");
        practiceFieldInfo[3].add("No events at this time");
        practiceFieldInfo[4].add("N/A");
        practiceFieldInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around College park and sets other information about College park
    void buildCollegeParkOutline()
    {
        collegeParkCoordinates = new LatLng[8];
        collegeParkCoordinates[0] = new LatLng(39.487061952456074, -80.16540538519621);
        collegeParkCoordinates[1] = new LatLng(39.485878394946035, -80.16469091176987);
        collegeParkCoordinates[2] = new LatLng(39.484335392805555, -80.16501512378454);
        collegeParkCoordinates[3] = new LatLng(39.48426449099566, -80.16483843326569);
        collegeParkCoordinates[4] = new LatLng(39.48493986661451, -80.16445152461529);
        collegeParkCoordinates[5] = new LatLng(39.48564680448914, -80.16442470252514);
        collegeParkCoordinates[6] = new LatLng(39.48633872720654, -80.16459234058857);
        collegeParkCoordinates[7] = new LatLng(39.487145530416875, -80.16524478793144);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 8; n++)
            temp.add(collegeParkCoordinates[n]);
        collegePark = map.addPolygon(temp);
        collegePark.setFillColor(Color.TRANSPARENT);
        collegePark.setStrokeColor(Color.TRANSPARENT);
        collegePark.setClickable(true);
        collegeParkCenter = new LatLng(39.485397617471314, -80.1645303145051);
        collegeParkMarker = map.addMarker(new MarkerOptions()
                        .position(collegeParkCenter)
                        .title("College Park Apartments")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        collegeParkInfo = new Vector[6];
        collegeParkInfo[0] = new Vector<String>();
        collegeParkInfo[1] = new Vector<String>();
        collegeParkInfo[2] = new Vector<String>();
        collegeParkInfo[3] = new Vector<String>();
        collegeParkInfo[4] = new Vector<String>();
        collegeParkInfo[5] = new Vector<String>();
        collegeParkInfo[0].add("College Park Apartments");
        collegeParkInfo[1].add("The College Park Apartments offers both furnished and unfurnished apartments.\n" +
                "Furnished apartments have extra long twin size beds, a couch and kitchen table with chairs. One, two, and three bedroom " +
                "apartments are available. The kitchen includes a stove, refrigerator, and microwave. Water, cable, Internet, sewage, " +
                "electric, and trash pick-up are included in the lease. However, telephone is solely the tenant’s responsibility. Laundry " +
                "services are available in each building and are available at no additional cost during the academic year\n");
        collegeParkInfo[2].add("N/A");
        collegeParkInfo[3].add("No events at this time");
        collegeParkInfo[4].add("Residence Life");
        collegeParkInfo[4].add("https://www.fairmontstate.edu/stulife/residence-life/college-park-apartments");
        collegeParkInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Folklife center and sets other information about Folklife center
    void buildFolklifeOutline()
    {
        folklifeCoordinates = new LatLng[4];
        folklifeCoordinates[0] = new LatLng(39.483454290364115, -80.16477104276419);
        folklifeCoordinates[1] = new LatLng(39.483241323253054, -80.16468923538923);
        folklifeCoordinates[2] = new LatLng(39.4832775509972, -80.16448840498924);
        folklifeCoordinates[3] = new LatLng(39.48349517583451, -80.16457591205835);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(folklifeCoordinates[n]);
        folklife = map.addPolygon(temp);
        folklife.setFillColor(Color.TRANSPARENT);
        folklife.setStrokeColor(Color.TRANSPARENT);
        folklife.setClickable(true);
        folklifeCenter = new LatLng(39.48337174304366, -80.16460876911879);
        folklifeMarker = map.addMarker(new MarkerOptions()
                        .position(folklifeCenter)
                        .title("Frank & Jane Gabor West Virginia Folklife Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        folklifeInfo = new Vector[6];
        folklifeInfo[0] = new Vector<String>();
        folklifeInfo[1] = new Vector<String>();
        folklifeInfo[2] = new Vector<String>();
        folklifeInfo[3] = new Vector<String>();
        folklifeInfo[4] = new Vector<String>();
        folklifeInfo[5] = new Vector<String>();
        folklifeInfo[0].add("Frank & Jane Gabor West Virginia Folklife Center");
        folklifeInfo[1].add("The Frank and Jane Gabor West Virginia Folklife Center is dedicated to the identification, " +
                "preservation, and perpetuation of our region's rich cultural heritage, through academic studies, educational programs, " +
                "festivals, performances, and publications, along with containing two minors in Folklore and Museum Studies under the " +
                "College of Liberal Arts. Named for alumni Frank and Jane Gabor, when the facility was known as Colonial Apartments, " +
                "it housed Dr. Ruth Ann Musick, a primary West Virginia folklore scholar, specializing in supernatural legends. It is " +
                "thought that Musick still visits the building on a regular basis. Originally the Kennedy Dairy Barn, the facility and " +
                "surrounding gardens were named to the National Register of Historic Places in 2006.\n");
        folklifeInfo[2].add("N/A");
        folklifeInfo[3].add("No events at this time");
        folklifeInfo[4].add("College of Liberal Arts");
        folklifeInfo[4].add(" ");
        folklifeInfo[4].add("Folklife Center");
        folklifeInfo[4].add("https://www.fairmontstate.edu/folklife/");
        folklifeInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Hunt Haught and sets other information about Hunt Haught
    void buildHuntHaughtOutline()
    {
        huntHaughtCoordinates = new LatLng[4];
        huntHaughtCoordinates[0] = new LatLng(39.48353347359512, -80.16391072422266);
        huntHaughtCoordinates[1] = new LatLng(39.483020851146044, -80.1638312637806);
        huntHaughtCoordinates[2] = new LatLng(39.48306277195261, -80.16349598765373);
        huntHaughtCoordinates[3] = new LatLng(39.48355132862494, -80.1635942235589);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(huntHaughtCoordinates[n]);
        huntHaught = map.addPolygon(temp);
        huntHaught.setFillColor(Color.TRANSPARENT);
        huntHaught.setStrokeColor(Color.TRANSPARENT);
        huntHaught.setClickable(true);
        huntHaughtCenter = new LatLng(39.48327651591906, -80.16366932541132);
        huntHaughtMarker = map.addMarker(new MarkerOptions()
                        .position(huntHaughtCenter)
                        .title("Hunt Haught Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        huntHaughtInfo = new Vector[6];
        huntHaughtInfo[0] = new Vector<String>();
        huntHaughtInfo[1] = new Vector<String>();
        huntHaughtInfo[2] = new Vector<String>();
        huntHaughtInfo[3] = new Vector<String>();
        huntHaughtInfo[4] = new Vector<String>();
        huntHaughtInfo[5] = new Vector<String>();
        huntHaughtInfo[0].add("Hunt Haught Hall");
        huntHaughtInfo[1].add("This building, completed in 1971, was named for George Hunt and Cleo Haught, " +
                "former faculty members. It houses the FSU College of Science and Technology's Biology, Chemistry, " +
                "and Geoscience Department. Hunt Haught Hall features a functioning green house, classrooms and labs.\n");
        huntHaughtInfo[2].add("Biology");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/biology-program");
        huntHaughtInfo[2].add("Biology Education");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/science-education");
        huntHaughtInfo[2].add("Chemistry");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/chemistry-program");
        huntHaughtInfo[2].add("Chemistry Education");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/science-education");
        huntHaughtInfo[2].add("Forensic Science");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/forensic-science-program");
        huntHaughtInfo[2].add("General Science Education");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/science-education");
        huntHaughtInfo[2].add("Physics Education");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/science-education");
        huntHaughtInfo[2].add("Pre-Dentistry");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/pre-professional-dentistry");
        huntHaughtInfo[2].add("Pre-Medicine");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/pre-professional-medicine");
        huntHaughtInfo[2].add("Pre-Pharmacy");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/pre-professional-pharmacy");
        huntHaughtInfo[2].add("Pre-Physical Therapy");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/pre-professional-physical-therapy");
        huntHaughtInfo[2].add("Pre-Professional");
        huntHaughtInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/pre-professional-studies");
        huntHaughtInfo[3].add("No events at this time");
        huntHaughtInfo[4].add("College of Science and Technology");
        huntHaughtInfo[4].add(" ");
        huntHaughtInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Library and sets other information about Library
    void buildLibraryOutline()
    {
        libraryCoordinates = new LatLng[5];
        libraryCoordinates[0] = new LatLng(39.48283117211911, -80.16270976513624);
        libraryCoordinates[1] = new LatLng(39.48281176427682, -80.16199562698603);
        libraryCoordinates[2] = new LatLng(39.48307752186001, -80.1619677990675);
        libraryCoordinates[3] = new LatLng(39.48320173148251, -80.16216292977333);
        libraryCoordinates[4] = new LatLng(39.483214669972085, -80.16267690807581);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 5; n++)
            temp.add(libraryCoordinates[n]);
        library = map.addPolygon(temp);
        library.setFillColor(Color.TRANSPARENT);
        library.setStrokeColor(Color.TRANSPARENT);
        library.setClickable(true);
        libraryCenter = new LatLng(39.483028355489836, -80.16236644238234);
        libraryMarker = map.addMarker(new MarkerOptions()
                        .position(libraryCenter)
                        .title("Ruth Ann Musick Library")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        libraryInfo = new Vector[6];
        libraryInfo[0] = new Vector<String>();
        libraryInfo[1] = new Vector<String>();
        libraryInfo[2] = new Vector<String>();
        libraryInfo[3] = new Vector<String>();
        libraryInfo[4] = new Vector<String>();
        libraryInfo[5] = new Vector<String>();
        libraryInfo[0].add("Ruth Ann Musick Library");
        libraryInfo[1].add("Built in 1950, the Library was renamed in 1980 in honor of Dr. Ruth Ann Musick. Musick was the " +
                "primary female folklore scholar to preserve and perpetuate the cultural heritage of West Virginia, mainly " +
                "through the recording of supernatural legends. Even in the technology age, the library is a hub of activity " +
                "on campus. In addition to the welcoming and devoted staff, the facility offers computer lounges, Starbucks " +
                "coffee bar, group study space, 50,000 e-books, 150 databases containing millions of articles, and virtual " +
                "reference by online chat support the educational process.\n");
        libraryInfo[2].add("N/A");
        libraryInfo[3].add("No events at this time");
        libraryInfo[4].add("Library Services");
        libraryInfo[4].add("http://library.fairmontstate.edu/about/staff");
        libraryInfo[5].add("- Regular Hours\n      Sunday\n         2:00 p.m. - 2:00 a.m.\n" +
                "      Monday - Thursday\n         7:00 a.m. - 2:00 a.m.\n" +
                "      Friday\n         7:00 a.m. - 10:00 p.m.\n" +
                "      Saturday\n         10:00 a.m. - 5:00 p.m.\n\n" +
                "- Starbucks \n" +
                "      Monday - Thursday\n" +
                "         7:00 am to 5:00 pm\n" +
                "      Friday\n" +
                "         7:00 am to 2:00 pm\n" +
                "      Saturday & Sunday\n" +
                "         CLOSED \n");
    }
    //==================================================================================================
//"Draws" line around Falcon Center and sets other information about Falcon Center
    void buildFalconCenterOutline()
    {
        falconCenterCoordinates = new LatLng[8];
        falconCenterCoordinates[0] = new LatLng(39.48430045944109, -80.16042720526457);
        falconCenterCoordinates[1] = new LatLng(39.48443010094979, -80.16058143228292);
        falconCenterCoordinates[2] = new LatLng(39.48460580232932, -80.16102366149426);
        falconCenterCoordinates[3] = new LatLng(39.48439490886753, -80.16142800450325);
        falconCenterCoordinates[4] = new LatLng(39.48407636795997, -80.161562114954);
        falconCenterCoordinates[5] = new LatLng(39.483725220849635, -80.16110848635435);
        falconCenterCoordinates[6] = new LatLng(39.483791465392265, -80.16071755439043);
        falconCenterCoordinates[7] = new LatLng(39.4838978188034, -80.16057807952166);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 8; n++)
            temp.add(falconCenterCoordinates[n]);
        falconCenter = map.addPolygon(temp);
        falconCenter.setFillColor(Color.TRANSPARENT);
        falconCenter.setStrokeColor(Color.TRANSPARENT);
        falconCenter.setClickable(true);
        falconCenterCenter = new LatLng(39.484144164766, -80.16102433204651);
        FalconCenterMarker = map.addMarker(new MarkerOptions()
                        .position(falconCenterCenter)
                        .title("Falcon Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        falconCenterInfo = new Vector[6];
        falconCenterInfo[0] = new Vector<String>();
        falconCenterInfo[1] = new Vector<String>();
        falconCenterInfo[2] = new Vector<String>();
        falconCenterInfo[3] = new Vector<String>();
        falconCenterInfo[4] = new Vector<String>();
        falconCenterInfo[5] = new Vector<String>();
        falconCenterInfo[0].add("Falcon Center");
        falconCenterInfo[1].add("This state-of-the-art student center features areas to work out, play intramural sports, " +
                "shop at the bookstore or grab a bite to eat. Hanging out between classes has never been so fun. " +
                "The building features a four-lane lap pool, whirlpool and sauna; two large gymnasiums; 7,000 square feet of " +
                "fitness equipment; \"Bound for Success\" bookstore; informal dining at the \"Nickel\" " +
                "and sit-down dining at the Dining Hall; the Copy Center; Student Health Services; Student Government Office; and Public Safety. " +
                "As a Falcon, you will spend lots of time in this amazing facility!\n");
        falconCenterInfo[2].add("N/A");
        falconCenterInfo[3].add("No events at this time");
        falconCenterInfo[4].add("Campus Card Services");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/falconcenter/campus-card-services");
        falconCenterInfo[4].add("Club Sports");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/falconcenter/fitness-activities/club-sports");
        falconCenterInfo[4].add("Conference Services");
        falconCenterInfo[4].add("http://www.fairmontstate.edu/falconcenter/conference-services");
        falconCenterInfo[4].add("Copy Center/Printing Services");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/adminfiscalaffairs/copy-center");
        falconCenterInfo[4].add("Dining Services");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/falconcenter/dining-services/dining-services-staff");
        falconCenterInfo[4].add("Falcon Center");
        falconCenterInfo[4].add("http://www.fairmontstate.edu/falconcenter/");
        falconCenterInfo[4].add("Public Safety");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/campuspolice/about-us");
        falconCenterInfo[4].add("Student Government Office");
        falconCenterInfo[4].add("http://www.fairmontstate.edu/stulife/student-government/student-government");
        falconCenterInfo[4].add("Student Health Services");
        falconCenterInfo[4].add("https://www.fairmontstate.edu/studentservices/health-services");
        falconCenterInfo[5].add(
                "- Falcon Center\n" +
                        "      Fall & Spring Semester\n" +
                        "         Monday-Thursday\n            6:00am-10:30pm\n         Friday\n            6:00am-8:00pm\n         Saturday\n           10am-6:00pm\n         Sunday\n            12:00-8:00pm\n\n" +
                        "      Summer Hours\n" +
                        "         Monday-Friday\n            6am-8pm\n         Saturday & Sunday\n            10am-6pm\n\n" +
                        "- Bound for Success Bookstore\n      Monday - Thursday\n         8:00am - 5:00pm\n" +
                        "      Friday\n         8:00am - 4:00pm\n" +
                        "      Saturday\n         CLOSED\n" +
                        "      Sunday\n         CLOSED\n\n" +
                        "- Copy Center/ Printing Services\n      Monday - Friday\n         8:00am - 4:00pm\n      Saturday & Sunday\n         CLOSED\n\n" +
                        "- Dining Hall\n" +
                        "      Monday-Friday\n" +
                        "         Breakfast\n            7:00 am to 10:00 am\n" +
                        "         Continental Breakfast\n            10:00 am to 11:00 am\n" +
                        "         Lunch\n            11:00 am - 2:00 pm\n" +
                        "         Lite Lunch\n            2:00 pm to 3:00 pm\n" +
                        "         Dinner\n            4:00 pm - 8:00 pm\n" +
                        "      Saturday & Sunday\n" +
                        "         Brunch\n            11:00 am to 1:00pm\n" +
                        "         Dinner\n            4:00 pm to 6:00 pm\n\n" +
                        "- Hershey’s and Ciabatta’s Subs\n" +
                        "      Monday - Thursday\n" +
                        "         11:00 am to 9:00 pm\n" +
                        "      Friday\n" +
                        "         11:00 am to 5:00 pm\n" +
                        "      Saturday & Sunday\n" +
                        "         CLOSED \n\n" +
                        "- Nickel\n" +
                        "      Monday - Thursday\n" +
                        "         7:00 am to 10:00 pm\n" +
                        "      Friday\n" +
                        "         7:00 am to 2:00 pm\n" +
                        "      Saturday & Sunday\n" +
                        "        Noon to 6:00 pm\n\n" +
                        "- Pool\n" +
                        "      Fall & Spring Semester\n" +
                        "         Monday\n" +
                        "            4:00pm-10:00pm\n" +
                        "         Tuesday\n" +
                        "            6:00am-8:00am\n" + "            4:00pm-10:00pm\n" +
                        "         Wednesday\n" +
                        "            4:00pm-10:00pm\n" +
                        "         Thursday\n" +
                        "            6:00am-8:00am\n" + "            4:00pm-10:00pm\n" +
                        "         Friday\n" +
                        "            4:00pm-8:00pm\n" +
                        "         Saturday\n" +
                        "            10:30am-4:30pm\n" +
                        "         Sunday\n" +
                        "            12:30pm-6:30pm\n\n" +
                        "      Summer Hours\n" +
                        "         Monday - Friday\n" +
                        "            2:00pm-6:00pm\n" +
                        "         Saturday & Sunday\n" +
                        "            CLOSED\n\n" +
                        "- Student Health Services\n" +
                        "      Monday - Friday\n" +
                        "         8:00am - 4:00pm\n" +
                        "      Saturday & Sunday\n" +
                        "         CLOSED"
        );
    }
    //==================================================================================================
//"Draws" line around Turley and sets other information about Turley
    void buildTurleyOutline()
    {
        turleyCoordinates = new LatLng[7];
        turleyCoordinates[0] = new LatLng(39.48261354520398, -80.16107395291328);
        turleyCoordinates[1] = new LatLng(39.482571882898824, -80.16141325235367);
        turleyCoordinates[2] = new LatLng(39.482660900464644, -80.16155675053596);
        turleyCoordinates[3] = new LatLng(39.48280710639385, -80.16160938888788);
        turleyCoordinates[4] = new LatLng(39.48292743493684, -80.16148298978806);
        turleyCoordinates[5] = new LatLng(39.48299393901001, -80.16109608113766);
        turleyCoordinates[6] = new LatLng(39.482753023174446, -80.1610092446208);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 7; n++)
            temp.add(turleyCoordinates[n]);
        turley = map.addPolygon(temp);
        turley.setFillColor(Color.TRANSPARENT);
        turley.setStrokeColor(Color.TRANSPARENT);
        turley.setClickable(true);
        turleyCenter = new LatLng(39.482792615200424, -80.16128618270159);
        turleyMarker = map.addMarker(new MarkerOptions()
                        .position(turleyCenter)
                        .title("Turley Student Services Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        turleyInfo = new Vector[6];
        turleyInfo[0] = new Vector<String>();
        turleyInfo[1] = new Vector<String>();
        turleyInfo[2] = new Vector<String>();
        turleyInfo[3] = new Vector<String>();
        turleyInfo[4] = new Vector<String>();
        turleyInfo[5] = new Vector<String>();
        turleyInfo[0].add("Turley Student Services Center");
        turleyInfo[1].add("Originally called the Student Center and built in 1959, the Turley Student " +
                "Services Center was officially opened in June of 2013 as a state-of-the-art facility " +
                "focused on providing all student services under one roof. This is the first place that " +
                "future Falcons visit when coming to take a campus tour and meet with an admissions counselor. " +
                "As a student, you can meet with financial aid, housing, advising, counseling, disability " +
                "services and career development. The Honors Program, International Student Services, Multicultural " +
                "Affairs and the Retention Office are also housed here.\n");
        turleyInfo[2].add("N/A");
        turleyInfo[3].add("No events at this time");
        turleyInfo[4].add("Academic Advising Center");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentresources/advisingcenter");
        turleyInfo[4].add("Career Services");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/career-services/career-development-center-staff");
        turleyInfo[4].add("Consumer Information");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/consumer-information");
        turleyInfo[4].add("Counseling Services");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/counseling-center/counseling-center");
        turleyInfo[4].add("Disability Services");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/disability-services/disability-services");
        turleyInfo[4].add("Financial Aid Office");
        turleyInfo[4].add("https://www.fairmontstate.edu/finaid/");
        turleyInfo[4].add("Housing & Residence Life");
        turleyInfo[4].add("http://www.fairmontstate.edu/stulife/residence-life");
        turleyInfo[4].add("International Student Services");
        turleyInfo[4].add("https://www.fairmontstate.edu/internationalstudents/");
        turleyInfo[4].add("Office of Admissions");
        turleyInfo[4].add("https://www.fairmontstate.edu/admit/visit-us");
        turleyInfo[4].add("Registrar");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/registrar/registrar-about-us");
        turleyInfo[4].add("Retention");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/retention/retention");
        turleyInfo[4].add("Veteran Services ");
        turleyInfo[4].add("https://www.fairmontstate.edu/studentservices/veteran-services");
        turleyInfo[5].add("- All offices in Turley Student Services Center are open:\n" +
                "      Monday – Wednesday\n" +
                "         8:00 am - 4:00 pm\n" +
                "      Thursday \n" +
                "         9:00 am - 4:00 pm\n" +
                "      Friday \n" +
                "         8:00 am - 4:00 pm\n");
    }
    //==================================================================================================
//"Draws" line around ET and sets other information about ET
    void buildETOutline()
    {
        ETCoordinates = new LatLng[4];
        ETCoordinates[0] = new LatLng(39.482349856031725, -80.16301319003105);
        ETCoordinates[1] = new LatLng(39.48261225134395, -80.16302291303873);
        ETCoordinates[2] = new LatLng(39.48258663291034, -80.16221825033426);
        ETCoordinates[3] = new LatLng(39.48232087345133, -80.16222294420004);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(ETCoordinates[n]);
        ET = map.addPolygon(temp);
        ET.setFillColor(Color.TRANSPARENT);
        ET.setStrokeColor(Color.TRANSPARENT);
        ET.setClickable(true);
        ETCenter = new LatLng(39.48247820731407, -80.16259845346212);
        ETmarker = map.addMarker(new MarkerOptions()
                        .position(ETCenter)
                        .title("Engineering Technology Building")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        ETInfo = new Vector[6];
        ETInfo[0] = new Vector<String>();
        ETInfo[1] = new Vector<String>();
        ETInfo[2] = new Vector<String>();
        ETInfo[3] = new Vector<String>();
        ETInfo[4] = new Vector<String>();
        ETInfo[5] = new Vector<String>();
        ETInfo[0].add("Engineering Technology Building");
        ETInfo[1].add("Completed in 2008, the Engineering Technology Building is home to the College of Science and Technology's " +
                "Computer Science, Math, and Physics Department as well as their Technology Department and Masters of Architecture " +
                "program. Also known as the ETC, this facility houses the concrete canoe team, Baja buggy team, and FSU's 3D printer. " +
                "The building features two large lecture rooms and 12 smaller laboratory classrooms.\n");

        ETInfo[2].add("Architectural Engineering Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/architecture-program");
        ETInfo[2].add("Architecture");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/architecture-program");
        ETInfo[2].add("Aviation Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/aviation-technology-program");
        ETInfo[2].add("Civil Engineering Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/civil-engineering-technology");
        ETInfo[2].add("Computer Science");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/computer-science-computer-security-programs");
        ETInfo[2].add("Electronics Engineering Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/electronics-engineering-technology");
        ETInfo[2].add("Graphic Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/graphics-technology");
        ETInfo[2].add("Information Systems Management");
        ETInfo[2].add("http://www.fairmontstate.edu/schoolofbusiness/academics/bs-degree-information-systems-management");
        ETInfo[2].add("Master of Architecture");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/master-architecture-program");
        ETInfo[2].add("Mathematics");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/math-program");
        ETInfo[2].add("Mathematics Education");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/math-program");
        ETInfo[2].add("Mechanical Engineering Technology");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/mechanical-engineering-technology");
        ETInfo[2].add("Occupational Safety");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/occupational-safety");
        ETInfo[2].add("Technology Education");
        ETInfo[2].add("http://www.fairmontstate.edu/collegeofscitech/academics/technology-education-program");
        ETInfo[3].add("No events at this time");
        ETInfo[4].add("College of Science and Technology");
        ETInfo[4].add(" ");
        ETInfo[4].add("Math Tutoring");
        ETInfo[4].add("https://www.fairmontstate.edu/academics/tutoring-services");
        ETInfo[4].add("School of Business");
        ETInfo[4].add("https://webfors.fairmontstate.edu/pls/prod_dad/bzpkedir.P_DeptDirectory?dir_indx=SCHOOLOFBUSINESS&next_row=1&prev_row=0&searchtype=D&cur_orgn=&ButtonSelected=");
        ETInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Wallman and sets other information about Wallman
    void buildWallmanOutline()
    {
        wallmanCoordinates = new LatLng[6];
        wallmanCoordinates[0] = new LatLng(39.48265934783367, -80.16205295920372);
        wallmanCoordinates[1] = new LatLng(39.48262674257496, -80.16178172081709);
        wallmanCoordinates[2] = new LatLng(39.48245207128586, -80.16167342662811);
        wallmanCoordinates[3] = new LatLng(39.48224815817412, -80.1618953794241);
        wallmanCoordinates[4] = new LatLng(39.482330706828165, -80.16215220093727);
        wallmanCoordinates[5] = new LatLng(39.482578610974635, -80.1621837168932);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 6; n++)
            temp.add(wallmanCoordinates[n]);
        wallman = map.addPolygon(temp);
        wallman.setFillColor(Color.TRANSPARENT);
        wallman.setStrokeColor(Color.TRANSPARENT);
        wallman.setClickable(true);
        wallmanCenter = new LatLng(39.482434215973825, -80.16189705580473);
        wallmanMarker = map.addMarker(new MarkerOptions()
                        .position(wallmanCenter)
                        .title("Wallman Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        wallmanInfo = new Vector[6];
        wallmanInfo[0] = new Vector<String>();
        wallmanInfo[1] = new Vector<String>();
        wallmanInfo[2] = new Vector<String>();
        wallmanInfo[3] = new Vector<String>();
        wallmanInfo[4] = new Vector<String>();
        wallmanInfo[5] = new Vector<String>();
        wallmanInfo[0].add("Wallman Hall");
        wallmanInfo[1].add("Wallman Hall was completed in 1967 and was known as the Fine and Applied Arts Building. In 1980, the " +
                "building was renamed for retired faculty member, Lawrence A. Wallman, who served for 41 years and was instrumental " +
                "in establishing the Speech and Drama Department. As the home of the School of Fine Arts, the building features classrooms " +
                "and faculty offices, box office, a newly renovated 400-seat theatre, the Tower Room Gallery and the James Brooks Memorial " +
                "Gallery. From students painting, sculpting, singing, playing instruments and practicing for performances, Wallman Hall is " +
                "always alive with activity and creativity.\n");
        wallmanInfo[2].add("Art Education");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/art-education");
        wallmanInfo[2].add("Communication Arts");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/communication-arts");
        wallmanInfo[2].add("Music");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/music-degrees-offered");
        wallmanInfo[2].add("Music Education");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/music-degrees-offered");
        wallmanInfo[2].add("Oral Communication");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/oral-communication");
        wallmanInfo[2].add("Studio Art");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/studio-art");
        wallmanInfo[2].add("Theatre");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/theatre");
        wallmanInfo[2].add("Theatre Education");
        wallmanInfo[2].add("http://www.fairmontstate.edu/schooloffinearts/academics/theatre-education");
        wallmanInfo[3].add("No events at this time");
        wallmanInfo[4].add("Department of Art");
        wallmanInfo[4].add(" ");
        wallmanInfo[4].add("Department of Communication and Theatre Arts");
        wallmanInfo[4].add(" ");
        wallmanInfo[4].add("Department of Music");
        wallmanInfo[4].add(" ");

        wallmanInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Education and sets other information about Education
    void buildEducationOutline()
    {
        educationCoordinates = new LatLng[4];
        educationCoordinates[0] = new LatLng(39.48317067909766, -80.16186721622944);
        educationCoordinates[1] = new LatLng(39.48347550940872, -80.16144711524248);
        educationCoordinates[2] = new LatLng(39.4837045194171, -80.16170293092728);
        educationCoordinates[3] = new LatLng(39.48342996608553, -80.16220718622208);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(educationCoordinates[n]);
        education = map.addPolygon(temp);
        education.setFillColor(Color.TRANSPARENT);
        education.setStrokeColor(Color.TRANSPARENT);
        education.setClickable(true);
        educationCenter = new LatLng(39.48341081717936, -80.1617706567049);
        educationMarker = map.addMarker(new MarkerOptions()
                        .position(educationCenter)
                        .title("Education Building")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        educationInfo = new Vector[6];
        educationInfo[0] = new Vector<String>();
        educationInfo[1] = new Vector<String>();
        educationInfo[2] = new Vector<String>();
        educationInfo[3] = new Vector<String>();
        educationInfo[4] = new Vector<String>();
        educationInfo[5] = new Vector<String>();
        educationInfo[0].add("Education Building");
        educationInfo[1].add("Completed in 1992, the Education Building houses the FSU School of Education and the School of Nursing " +
                "and Allied Health Administration. It also houses the Center for Teaching Excellence and the Master of Arts in Teaching " +
                "faculty.");
        educationInfo[2].add("Community Health Education");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/community-health-education");
        educationInfo[2].add("Elementary Education");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/elementary-education");
        educationInfo[2].add("Exercise Science");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/exercise-science");
        educationInfo[2].add("Health Education");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/academic-programs/secondary-ed-health-specialization");
        educationInfo[2].add("Master of Arts in Teaching");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/master-arts-teaching-mat?utm_source=master-of-arts-teaching&utm_" +
                "medium=grad-studies-web&utm_campaign=program-highlights");
        educationInfo[2].add("Master of Education");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofeducation/master-education-med?utm_source=master-of-ed&utm_medium=grad-studies-web&utm_campaign=program-highlights");
        educationInfo[2].add("Nursing ASN");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofnaha/academics/associate-degree-program");
        educationInfo[2].add("Nursing ASN/ Articulation");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofnaha/academics/lpn-articulation-program");
        educationInfo[2].add("Nursing BSN");
        educationInfo[2].add("http://www.fairmontstate.edu/schoolofnaha/academics/bachelor-degree-program");
        educationInfo[3].add("No events at this time");
        educationInfo[4].add("School of Education");
        educationInfo[4].add(" ");
        educationInfo[4].add("School of Nursing and Allied Health Administration");
        educationInfo[4].add(" ");
        educationInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Colebank and sets other information about Colebank
    void buildColebankOutline()
    {
        colebankCoordinates = new LatLng[4];
        colebankCoordinates[0] = new LatLng(39.48327030544988, -80.1609743759036);
        colebankCoordinates[1] = new LatLng(39.48339684364992, -80.16079466789961);
        colebankCoordinates[2] = new LatLng(39.48380466253973, -80.16126472502947);
        colebankCoordinates[3] = new LatLng(39.48370633079271, -80.16148768365383);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(colebankCoordinates[n]);
        colebank = map.addPolygon(temp);
        colebank.setFillColor(Color.TRANSPARENT);
        colebank.setStrokeColor(Color.TRANSPARENT);
        colebank.setClickable(true);
        colebankCenter = new LatLng(39.483525193000006, -80.16114670783281);
        colebankMarker = map.addMarker(new MarkerOptions()
                        .position(colebankCenter)
                        .title("Colebank Hall")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        colebankInfo = new Vector[6];
        colebankInfo[0] = new Vector<String>();
        colebankInfo[1] = new Vector<String>();
        colebankInfo[2] = new Vector<String>();
        colebankInfo[3] = new Vector<String>();
        colebankInfo[4] = new Vector<String>();
        colebankInfo[5] = new Vector<String>();
        colebankInfo[0].add("Colebank Hall");
        colebankInfo[1].add("This building, formerly known as Colebank Gymnasium and completed in 1940, was renamed Colebank " +
                "Hall in 1987 in honor of Jasper Colebank, a former coach and faculty member. The gymnasium was at one time " +
                "used for FSU athletic events but today serves as a multi-use space for concerts, large meetings, dances, " +
                "and athletic activities. The Nursing Simultaion Center, and offices for Information Technology are located " +
                "on the first floor. Today, the building attaches to the Falcon Center, a combined facility for student" +
                " recreation and student union activities, and houses offices for Student Activities and Events and the" +
                " Department of Health and Human Performance on the third floor.\n");
        colebankInfo[2].add("N/A");
        colebankInfo[3].add("No events at this time");
        colebankInfo[4].add("Information Technology");
        colebankInfo[4].add("https://www.fairmontstate.edu/it/information-technology-staff#");
        colebankInfo[4].add("Student Organizations");
        colebankInfo[4].add("https://www.fairmontstate.edu/stulife/student-organizations");
        colebankInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Alumni Center and sets other information about Alumni Center
    void buildAlumniCenterOutline()
    {
        alumniCenterCoordinates = new LatLng[4];
        alumniCenterCoordinates[0] = new LatLng(39.481665139341814, -80.16254715621471);
        alumniCenterCoordinates[1] = new LatLng(39.48151297916196, -80.16243316233158);
        alumniCenterCoordinates[2] = new LatLng(39.48166022260652, -80.16222462058067);
        alumniCenterCoordinates[3] = new LatLng(39.48176373275004, -80.16228631138802);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(alumniCenterCoordinates[n]);
        alumniCenter = map.addPolygon(temp);
        alumniCenter.setFillColor(Color.TRANSPARENT);
        alumniCenter.setStrokeColor(Color.TRANSPARENT);
        alumniCenter.setClickable(true);
        alumniCenterCenter = new LatLng(39.48164495484732, -80.16239024698734);
        alumniCenterMarker = map.addMarker(new MarkerOptions()
                        .position(alumniCenterCenter)
                        .title("Erickson Alumni Center")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        alumniCenterInfo = new Vector[6];
        alumniCenterInfo[0] = new Vector<String>();
        alumniCenterInfo[1] = new Vector<String>();
        alumniCenterInfo[2] = new Vector<String>();
        alumniCenterInfo[3] = new Vector<String>();
        alumniCenterInfo[4] = new Vector<String>();
        alumniCenterInfo[5] = new Vector<String>();
        alumniCenterInfo[0].add("Erickson Alumni Center");
        alumniCenterInfo[1].add("...");
        alumniCenterInfo[2].add("N/A");
        alumniCenterInfo[3].add("No events at this time");
        alumniCenterInfo[4].add("FSU Fighting Falcons $1,000 Club");
        alumniCenterInfo[4].add("http://www.fairmontstate.edu/alumni/fsu-fighting-falcons-1000-club");
        alumniCenterInfo[4].add("The Office of Alumni Relations");
        alumniCenterInfo[4].add("http://www.fairmontstate.edu/alumni/about-us");
        alumniCenterInfo[5].add("N/A");
    }
    //==================================================================================================
//"Draws" line around Wesley Foundation and sets other information about Wesley Foundation
    void buildWesleyOutline()
    {
        wesleyCoordinates = new LatLng[4];
        wesleyCoordinates[0] = new LatLng(39.481758298471334, -80.16212470829487);
        wesleyCoordinates[1] = new LatLng(39.481671867505355, -80.1620901748538);
        wesleyCoordinates[2] = new LatLng(39.48169412219548, -80.1619865745306);
        wesleyCoordinates[3] = new LatLng(39.4817738249808, -80.16201876103878);
        PolygonOptions temp;
        temp = new PolygonOptions();
        for(int n = 0; n < 4; n++)
            temp.add(wesleyCoordinates[n]);
        wesley = map.addPolygon(temp);
        wesley.setFillColor(Color.TRANSPARENT);
        wesley.setStrokeColor(Color.TRANSPARENT);
        wesley.setClickable(true);
        wesleyCenter = new LatLng(39.48172025850853, -80.16205161809921);
        wesleyMarker = map.addMarker(new MarkerOptions()
                        .position(wesleyCenter)
                        .title("Wesley Foundation")
                        .icon(BitmapDescriptorFactory.defaultMarker(42))
        );
        wesleyInfo = new Vector[6];
        wesleyInfo[0] = new Vector<String>();
        wesleyInfo[1] = new Vector<String>();
        wesleyInfo[2] = new Vector<String>();
        wesleyInfo[3] = new Vector<String>();
        wesleyInfo[4] = new Vector<String>();
        wesleyInfo[5] = new Vector<String>();
        wesleyInfo[0].add("Wesley Foundation");
        wesleyInfo[1].add("Wesley Foundation is a Campus Ministry to the college. The United Methodist" +
                " Church and the Presbyterian Church sponsor this ministry. Housed near the entrance to " +
                "the campus beside the Alumni Center, the facility is available for meetings, receptions, " +
                "relaxation, and study. Individuals are encouraged to drop in at any time. Campus groups and " +
                "organizations are invited to schedule meetings and activities here. Participation in Wesley " +
                "Foundation programs and the benefits of the Foundation's services are not limited to any particular" +
                " religious affiliation, but are open to everyone in the college community. A prayer chapel is available" +
                " on the second floor for persons of any faith. Contact the Wesley Foundation at (304) 363-8210.");
        wesleyInfo[2].add("N/A");
        wesleyInfo[3].add("No events at this time");
        wesleyInfo[4].add("N/A");
        wesleyInfo[5].add("The Wesley Foundation offers a free home-cooked meal to students on Tuesdays and Thursdays from 11:30-1:00 PM.\n");
    }
    //==================================================================================================
//Returns the Polyline that outlines campus
    PolylineOptions getCampusBoundaryLine()
    {
        return  campusOutline;
    }
    //==================================================================================================
//Returns the coordinates for the center of campus
    LatLng getCampusCenter()
    {
        return fairmont;
    }
    //==================================================================================================
//Returns the coordinates for Schoolhouse
    LatLng getSchoolHouseCenter()
    {
        return schoolHouseCenter;
    }
    //==================================================================================================
//Returns the coordinates for Hardway
    LatLng getHardwayCenter()
    {
        return hardwayCenter;
    }
    //==================================================================================================
//Returns the coordinates for Parking garage
    LatLng getParkingGarageCenter()
    {
        return parkingGarageCenter;
    }
    //==================================================================================================
//Returns the coordinates for Bryant
    LatLng getBryantCenter()
    {
        return bryantCenter;
    }
    //==================================================================================================
//Returns the coordinates for Newman
    LatLng getNewmanCenter()
    {
        return newmanCenter;
    }
    //==================================================================================================
//Returns the coordinates for Jaynes
    LatLng getJaynesCenter()
    {
        return jaynesCenter;
    }
    //==================================================================================================
//Returns the coordinates for Morrow
    LatLng getMorrowCenter()
    {
        return morrowCenter;
    }
    //==================================================================================================
//Returns the coordinates for Prichard
    LatLng getPrichardCenter()
    {
        return prichardCenter;
    }
    //==================================================================================================
//Returns the coordinates for Pence
    LatLng getPenceCenter()
    {
        return penceCenter;
    }
    //==================================================================================================
//Returns the coordinates for Shaw
    LatLng getShawCenter()
    {
        return shawCenter;
    }
    //==================================================================================================
//Returns the coordinates for the Feaster Center
    LatLng getFeasterCenterCenter()
    {
        return feasterCenterCenter;
    }
    //==================================================================================================
//Returns the coordinates for Duvall-Rosier
    LatLng getDuvallCenter()
    {
        return duvallCenter;
    }
    //==================================================================================================
//Returns the coordinates for Physical plant
    LatLng getPhysicalPlantCenter()
    {
        return physicalPlantCenter;
    }
    //==================================================================================================
//Returns the coordinates for Tennis courts
    LatLng getTennisCourtCenter()
    {
        return tennisCourtCenter;
    }
    //==================================================================================================
//Returns the coordinates for Practice field
    LatLng getPracticeFieldCenter()
    {
        return practiceFieldCenter;
    }
    //==================================================================================================
//Returns the coordinates for College park
    LatLng getCollegeParkCenter()
    {
        return collegeParkCenter;
    }
    //==================================================================================================
    //Returns the coordinates for Folklife center
    LatLng getFolklifeCenter()
    {
        return folklifeCenter;
    }
    //==================================================================================================
//Returns the coordinates for Hunt Haught
    LatLng getHuntHaughtCenter()
    {
        return huntHaughtCenter;
    }
    //==================================================================================================
//Returns the coordinates for Library
    LatLng getLibraryCenter()
    {
        return libraryCenter;
    }
    //==================================================================================================
//Returns the coordinates for the Falcon Center
    LatLng getFalconCenterCenter()
    {
        return falconCenterCenter;
    }
    //==================================================================================================
//Returns the coordinates for ET
    LatLng getETCenter()
    {
        return ETCenter;
    }
    //==================================================================================================
//Returns the coordinates for Wallman
    LatLng getWallmanCenter()
    {
        return wallmanCenter;
    }
    //==================================================================================================
//Returns the coordinates for Turley
    LatLng getTurleyCenter()
    {
        return turleyCenter;
    }
    //==================================================================================================
//Returns the coordinates for Education
    LatLng getEducationCenter()
    {
        return educationCenter;
    }
    //==================================================================================================
//Returns the coordinates for Colebank
    LatLng getColebankCenter()

    {
        return colebankCenter;
    }
    //==================================================================================================
//Returns the coordinates for Alumni Center
    LatLng getAlumniCenterCenter()

    {
        return alumniCenterCenter;
    }
    //==================================================================================================
//Returns the coordinates for Wesley
    LatLng getWesleyCenter()

    {
        return wesleyCenter;
    }
    //==================================================================================================
//Returns information about clicked on building
    Vector[] getBuildingInfo(Marker marker)
    {
        String name;
        name = marker.getTitle();
        if(name.equals("Bryant Place"))
            return bryantInfo;
        else if(name.equals("Colebank Hall"))
            return colebankInfo;
        else if(name.equals("College Park Apartments"))
            return collegeParkInfo;
        else if(name.equals("Duvall-Rosier Field"))
            return duvallInfo;
        else if(name.equals("Education Building"))
            return educationInfo;
        else if(name.equals("Engineering Technology Building"))
            return ETInfo;
        else if(name.equals("Erickson Alumni Center"))
            return alumniCenterInfo;
        else if(name.equals("Falcon Center"))
            return falconCenterInfo;
        else if(name.equals("Feaster Center"))
            return feasterCenterInfo;
        else if(name.equals("Frank and Jane Gabor West Virginia Folklife Center"))
            return folklifeInfo;
        else if(name.equals("Hardway Hall"))
            return hardwayInfo;
        else if(name.equals("Hunt Haught Hall"))
            return huntHaughtInfo;
        else if(name.equals("Jaynes Hall"))
            return jaynesInfo;
        else if(name.equals("Morrow Hall"))
            return morrowInfo;
        else if(name.equals("Newman Center"))
            return newmanInfo;
        else if(name.equals("One Room Schoolhouse Museum"))
            return schoolHouseInfo;
        else if(name.equals("Parking Garage"))
            return parkingGarageInfo;
        else if(name.equals("Pence Hall"))
            return penceInfo;
        else if(name.equals("Physical Plant Building"))
            return physicalPlantInfo;
        else if(name.equals("Practice Field"))
            return practiceFieldInfo;
        else if(name.equals("Prichard Hall"))
            return prichardInfo;
        else if(name.equals("Ruth Ann Musick Library"))
            return libraryInfo;
        else if(name.equals("Shaw House"))
            return shawInfo;
        else if(name.equals("Tennis Courts"))
            return tennisCourtInfo;
        else if(name.equals("Turley Student Services Center"))
            return turleyInfo;
        else if(name.equals("Wallman Hall"))
            return wallmanInfo;
        else if(name.equals("Wesley Foundation"))
            return wesleyInfo;
        else if(name.equals("Wesley Foundation"))
            return wesleyInfo;
        else
            return null;
    }
    //==================================================================================================
//Returns the latitude and longitude of searched building and shows info window
    LatLng findBuilding(String name)
    {
        if(name.contains("Bryant Place") || "Bryant Place".contains(name))
        {
            bryantMarker.showInfoWindow();
            return bryantCenter;
        }
        else if(name.contains("Colebank Hall") || "Colebank Hall".contains(name))
        {
            colebankMarker.showInfoWindow();
            return colebankCenter;
        }
        else if(name.contains("College Park Apartments")||"College Park Apartments".contains(name))
        {
            collegeParkMarker.showInfoWindow();
            return collegeParkCenter;
        }
        else if(name.contains("Duvall-Rosier Field")||"Duvall-Rosier Field".contains(name))
        {
            duvallMarker.showInfoWindow();
            return duvallCenter;
        }
        else if(name.contains("Education Building")||"Education Building".contains(name))
        {
            educationMarker.showInfoWindow();
            return educationCenter;
        }
        else if(name.contains("Engineering Technology Building")||"Engineering Technology Building".contains(name))
        {
            ETmarker.showInfoWindow();
            return ETCenter;
        }
        else if(name.contains("Erickson Alumni Center")||"Erickson Alumni Center".contains(name))
        {
            alumniCenterMarker.showInfoWindow();
            return alumniCenterCenter;
        }
        else if(name.contains("Falcon Center")||"Falcon Center".contains(name))
        {
            FalconCenterMarker.showInfoWindow();
            return falconCenterCenter;
        }
        else if(name.contains("Feaster Center")||"Feaster Center".contains(name))
        {
            feasterCenterMarker.showInfoWindow();
            return feasterCenterCenter;
        }
        else if (name.contains("Frank and Jane Gabor West Virginia Folklife Center")||"Frank and Jane Gabor West Virginia Folklife Center".contains(name))
        {
            folklifeMarker.showInfoWindow();
            return folklifeCenter;
        }
        else if(name.contains("Hardway Hall")||"Hardway Hall".contains(name))
        {
            hardwayMarker.showInfoWindow();
            return hardwayCenter;
        }
        else if(name.contains("Hunt Haught Hall")||"Hunt Haught Hall".contains(name))
        {
            huntHaughtMarker.showInfoWindow();
            return huntHaughtCenter;
        }
        else if(name.contains("Jaynes Hall")||"Jaynes Hall".contains(name))
        {
            jaynesMarker.showInfoWindow();
            return jaynesCenter;
        }
        else if(name.contains("Morrow Hall")||"Morrow Hall".contains(name))
        {
            morrowMarker.showInfoWindow();
            return morrowCenter;
        }
        else if(name.contains("Newman Center")||"Newman Center".contains(name))
        {
            newmanMarker.showInfoWindow();
            return newmanCenter;
        }
        else if (name.contains("One Room Schoolhouse Museum")||"One Room Schoolhouse Museum".contains(name))
        {
            schoolHouseMarker.showInfoWindow();
            return schoolHouseCenter;
        }
        else if(name.contains("Parking Garage")||"Parking Garage".contains(name))
        {
            parkingGarageMarker.showInfoWindow();
            return parkingGarageCenter;
        }
        else if(name.contains("Pence Hall")||"Pence Hall".contains(name))
        {
            penceMarker.showInfoWindow();
            return penceCenter;
        }
        else if (name.contains("Physical Plant Building")||"Physical Plant Building".contains(name))
        {
            physicalPlantMarker.showInfoWindow();
            return physicalPlantCenter;
        }
        else if(name.contains("Practice Field")||"Practice Field".contains(name))
        {
            practiceFieldMarker.showInfoWindow();
            return practiceFieldCenter;
        }
        else if(name.contains("Prichard Hall")||"Prichard Hall".contains(name))
        {
            prichardMarker.showInfoWindow();
            return prichardCenter;
        }
        else if (name.contains("Ruth Ann Musick Library")||"Ruth Ann Musick Library".contains(name))
        {
            libraryMarker.showInfoWindow();
            return libraryCenter;
        }
        else if(name.contains("Shaw House")||"Shaw House".contains(name))
        {
            shawMarker.showInfoWindow();
            return shawCenter;
        }
        else if(name.contains("Tennis Courts")||"Tennis Courts".contains(name))
        {
            tennisCourtMarker.showInfoWindow();
            return tennisCourtCenter;
        }
        else if (name.contains("Turley Student Services Center")||"Turley Student Services Center".contains(name))
        {
            turleyMarker.showInfoWindow();
            return turleyCenter;
        }
        else if(name.contains("Wallman Hall")||"Wallman Hall".contains(name))
        {
            wallmanMarker.showInfoWindow();
            return wallmanCenter;
        }
        else if(name.contains("Wesley Foundation")||"Wesley Foundation".contains(name))
        {
            wesleyMarker.showInfoWindow();
            return wesleyCenter;
        }
        else
            return null;
    }
    //==================================================================================================
//Returns whether location for event is valid location
    Marker checkIfClickable(String eventLocation)
    {
        if(eventLocation.equals("Bryant Place"))
            return bryantMarker;
        else if(eventLocation.equals("Colebank Hall"))
            return colebankMarker;
        else if(eventLocation.equals("College Park Apartments"))
            return collegeParkMarker;
        else if(eventLocation.equals("Duvall-Rosier Field"))
            return duvallMarker;
        else if(eventLocation.equals("Education Building"))
            return educationMarker;
        else if(eventLocation.equals("Engineering Technology Building"))
            return ETmarker;
        else if(eventLocation.equals("Erickson Alumni Center"))
            return alumniCenterMarker;
        else if(eventLocation.equals("Falcon Center"))
            return FalconCenterMarker;
        else if(eventLocation.equals("Feaster Center"))
            return feasterCenterMarker;
        else if(eventLocation.equals("Frank and Jane Gabor West Virginia Folklife Center"))
            return folklifeMarker;
        else if(eventLocation.equals("Hardway Hall"))
            return hardwayMarker;
        else if(eventLocation.equals("Hunt Haught Hall"))
            return huntHaughtMarker;
        else if(eventLocation.equals("Jaynes Hall"))
            return jaynesMarker;
        else if(eventLocation.equals("Morrow Hall"))
            return morrowMarker;
        else if(eventLocation.equals("Newman Center"))
            return newmanMarker;
        else if(eventLocation.equals("One Room Schoolhouse Museum"))
            return schoolHouseMarker;
        else if(eventLocation.equals("Parking Garage"))
            return parkingGarageMarker;
        else if(eventLocation.equals("Pence Hall"))
            return penceMarker;
        else if(eventLocation.equals("Physical Plant Building"))
            return physicalPlantMarker;
        else if(eventLocation.equals("Practice Field"))
            return practiceFieldMarker;
        else if(eventLocation.equals("Prichard Hall"))
            return prichardMarker;
        else if(eventLocation.equals("Ruth Ann Musick Library"))
            return libraryMarker;
        else if(eventLocation.equals("Shaw House"))
            return shawMarker;
        else if(eventLocation.equals("Tennis Courts"))
            return tennisCourtMarker;
        else if(eventLocation.equals("Turley Student Services Center"))
            return turleyMarker;
        else if(eventLocation.equals("Wallman Hall"))
            return wallmanMarker;
        else if(eventLocation.equals("Wesley Foundation"))
            return wesleyMarker;
        else
            return null;
    }
    //==================================================================================================
//Checks and returns whether given Latitude and Longitude is within the boundaries of campus
    public boolean checkBoundaries(LatLng coordinates)
    {
        LatLngBounds topBounds = new LatLngBounds(new LatLng(39.486160442617305, -80.16768358647823),
                new LatLng(39.490118822173535, -80.16121409833431));
        LatLngBounds lowBounds = new LatLngBounds(new LatLng(39.480818420643764 ,-80.16573529690504),
                new LatLng(39.487220828122176, -80.15841823071241));
        if(topBounds.contains(coordinates))
            return true;
        if(lowBounds.contains(coordinates))
            return true;
        return false;
    }
    //==================================================================================================
//Shows polyline for closest building to building user is trying to go to
    void route(Marker m,LatLng userLocation)
    {
        Marker closestMarker;
        closestMarker = findClosestBuilding(userLocation);

        if(m.equals(closestMarker))
            Toast.makeText(mapsActivity,"You are closest to building trying to be routed to",Toast.LENGTH_LONG);
        else if(m.equals(FalconCenterMarker) || closestMarker.equals(FalconCenterMarker))           //If falcon center is the to or from location
        {
            if ((m.equals(FalconCenterMarker) && closestMarker.equals(schoolHouseMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(schoolHouseMarker)))
            {
                falconCenterToSchoolHouse.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(hardwayMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(hardwayMarker)))
            {
                falconCenterToHardway.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(parkingGarageMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(parkingGarageMarker)))
            {
                falconCenterToParkingGarage.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(bryantMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(bryantMarker)))
            {
                falconCenterToBryant.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(newmanMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(newmanMarker)))
            {
                falconCenterToNewman.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(jaynesMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(jaynesMarker)))
            {
                falconCenterToJaynes.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(morrowMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(morrowMarker)))
            {
                falconCenterToMorrow.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(prichardMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(prichardMarker)))
            {
                falconCenterToPrichard.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(penceMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(penceMarker)))
            {
                falconCenterToPence.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(shawMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(shawMarker)))
            {
                falconCenterToShaw.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(feasterCenterMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(feasterCenterMarker)))
            {
                falconCenterToFeasterCenter.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(duvallMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(duvallMarker)))
            {
                falconCenterToDuvall.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(physicalPlantMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(physicalPlantMarker)))
            {
                falconCenterToPhysicalPlant.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(tennisCourtMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(tennisCourtMarker)))
            {
                falconCenterToTennisCourts.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(practiceFieldMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(practiceFieldMarker)))
            {
                falconCenterToPracticeField.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(collegeParkMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(collegeParkMarker)))
            {
                falconCenterToCollegePark.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(folklifeMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(folklifeMarker)))
            {
                falconCenterToFolklife.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(huntHaughtMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(huntHaughtMarker)))
            {
                falconCenterToHuntHaught.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(libraryMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(libraryMarker)))
            {
                falconCenterToLibrary.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(ETmarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(ETmarker)))
            {
                falconCenterToET.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(wallmanMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(wallmanMarker)))
            {
                falconCenterToWallman.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(turleyMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(turleyMarker)))
            {
                falconCenterToTurley.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(educationMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(educationMarker)))
            {
                falconCenterToEducation.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(colebankMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(colebankMarker)))
            {
                falconCenterToColebank.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(alumniCenterMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(alumniCenterMarker)))
            {
                falconCenterToAlumniCenter.setVisible(true);
            }
            else if ((m.equals(FalconCenterMarker) && closestMarker.equals(wesleyMarker)) || (closestMarker.equals(FalconCenterMarker) && m.equals(wesleyMarker)))
            {
                falconCenterToWesley.setVisible(true);
            }
        }
    }
    //==================================================================================================
//Finds the building that is the shortest distance from a given location
    Marker findClosestBuilding(LatLng location)
    {
        double minDistance;
        double currentDistance;
        Marker closest;
        minDistance = (location.latitude - schoolHouseCenter.latitude) * (location.latitude - schoolHouseCenter.latitude)
                + (location.longitude - schoolHouseCenter.longitude) * (location.longitude - schoolHouseCenter.longitude);
        closest = schoolHouseMarker;
        currentDistance = (location.latitude - hardwayCenter.latitude) * (location.latitude - hardwayCenter.latitude)
                + (location.longitude - hardwayCenter.longitude) * (location.longitude - hardwayCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = hardwayMarker;
        }
        currentDistance = (location.latitude - parkingGarageCenter.latitude) * (location.latitude - parkingGarageCenter.latitude)
                + (location.longitude - parkingGarageCenter.longitude) * (location.longitude - parkingGarageCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = parkingGarageMarker;
        }
        currentDistance = (location.latitude - bryantCenter.latitude) * (location.latitude - bryantCenter.latitude)
                + (location.longitude - bryantCenter.longitude) * (location.longitude - bryantCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = bryantMarker;
        }
        currentDistance = (location.latitude - newmanCenter.latitude) * (location.latitude - newmanCenter.latitude)
                + (location.longitude - newmanCenter.longitude) * (location.longitude - newmanCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = newmanMarker;
        }
        currentDistance = (location.latitude - jaynesCenter.latitude) * (location.latitude - jaynesCenter.latitude)
                + (location.longitude - jaynesCenter.longitude) * (location.longitude - jaynesCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = jaynesMarker;
        }
        currentDistance = (location.latitude - morrowCenter.latitude) * (location.latitude - morrowCenter.latitude)
                + (location.longitude - morrowCenter.longitude) * (location.longitude - morrowCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = morrowMarker;
        }
        currentDistance = (location.latitude - prichardCenter.latitude) * (location.latitude - prichardCenter.latitude)
                + (location.longitude - prichardCenter.longitude) * (location.longitude - prichardCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = prichardMarker;
        }
        currentDistance = (location.latitude - penceCenter.latitude) * (location.latitude - penceCenter.latitude)
                + (location.longitude - penceCenter.longitude) * (location.longitude - penceCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = penceMarker;
        }
        currentDistance = (location.latitude - shawCenter.latitude) * (location.latitude - shawCenter.latitude)
                + (location.longitude - shawCenter.longitude) * (location.longitude - shawCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = shawMarker;
        }
        currentDistance = (location.latitude - feasterCenterCenter.latitude) * (location.latitude - feasterCenterCenter.latitude)
                + (location.longitude - feasterCenterCenter.longitude) * (location.longitude - feasterCenterCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = feasterCenterMarker;
        }
        currentDistance = (location.latitude - duvallCenter.latitude) * (location.latitude - duvallCenter.latitude)
                + (location.longitude - duvallCenter.longitude) * (location.longitude - duvallCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = duvallMarker;
        }
        currentDistance = (location.latitude - physicalPlantCenter.latitude) * (location.latitude - physicalPlantCenter.latitude)
                + (location.longitude - physicalPlantCenter.longitude) * (location.longitude - physicalPlantCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = physicalPlantMarker;
        }
        currentDistance = (location.latitude - tennisCourtCenter.latitude) * (location.latitude - tennisCourtCenter.latitude)
                + (location.longitude - tennisCourtCenter.longitude) * (location.longitude - tennisCourtCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = tennisCourtMarker;
        }
        currentDistance = (location.latitude - practiceFieldCenter.latitude) * (location.latitude - practiceFieldCenter.latitude)
                + (location.longitude - practiceFieldCenter.longitude) * (location.longitude - practiceFieldCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = practiceFieldMarker;
        }
        currentDistance = (location.latitude - collegeParkCenter.latitude) * (location.latitude - collegeParkCenter.latitude)
                + (location.longitude - collegeParkCenter.longitude) * (location.longitude - collegeParkCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = collegeParkMarker;
        }
        currentDistance = (location.latitude - folklifeCenter.latitude) * (location.latitude - folklifeCenter.latitude)
                + (location.longitude - folklifeCenter.longitude) * (location.longitude - folklifeCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = folklifeMarker;
        }
        currentDistance = (location.latitude - huntHaughtCenter.latitude) * (location.latitude - huntHaughtCenter.latitude)
                + (location.longitude - huntHaughtCenter.longitude) * (location.longitude - huntHaughtCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = huntHaughtMarker;
        }
        currentDistance = (location.latitude - libraryCenter.latitude) * (location.latitude - libraryCenter.latitude)
                + (location.longitude - libraryCenter.longitude) * (location.longitude - libraryCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = libraryMarker;
        }
        currentDistance = (location.latitude - ETCenter.latitude) * (location.latitude - ETCenter.latitude)
                + (location.longitude - ETCenter.longitude) * (location.longitude - ETCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = ETmarker;
        }
        currentDistance = (location.latitude - wallmanCenter.latitude) * (location.latitude - wallmanCenter.latitude)
                + (location.longitude - wallmanCenter.longitude) * (location.longitude - wallmanCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = wallmanMarker;
        }
        currentDistance = (location.latitude - turleyCenter.latitude) * (location.latitude - turleyCenter.latitude)
                + (location.longitude - turleyCenter.longitude) * (location.longitude - turleyCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = turleyMarker;
        }
        currentDistance = (location.latitude - educationCenter.latitude) * (location.latitude - educationCenter.latitude)
                + (location.longitude - educationCenter.longitude) * (location.longitude - educationCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = educationMarker;
        }
        currentDistance = (location.latitude - colebankCenter.latitude) * (location.latitude - colebankCenter.latitude)
                + (location.longitude - colebankCenter.longitude) * (location.longitude - colebankCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = colebankMarker;
        }
        currentDistance = (location.latitude - alumniCenterCenter.latitude) * (location.latitude - alumniCenterCenter.latitude)
                + (location.longitude - alumniCenterCenter.longitude) * (location.longitude - alumniCenterCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = alumniCenterMarker;
        }
        currentDistance = (location.latitude - wesleyCenter.latitude) * (location.latitude - wesleyCenter.latitude)
                + (location.longitude - wesleyCenter.longitude) * (location.longitude - wesleyCenter.longitude);
        if(currentDistance < minDistance)
        {
            minDistance = currentDistance;
            closest = wesleyMarker;
        }
        return closest;
    }
    //==================================================================================================
//Hides all of the routing polylines
    void hideRouting()
    {
        int count;
        count = lineArray.size();
        for(int n = 0; n < count; n++)
        {
            if(lineArray.elementAt(n).isVisible())
                lineArray.elementAt(n).setVisible(false);
        }

    }
}
