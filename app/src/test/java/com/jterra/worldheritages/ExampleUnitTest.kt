package com.jterra.worldheritages

import com.jterra.worldheritages.Common.Utils
import com.jterra.worldheritages.Heritage.HeritageActivity
import com.jterra.worldheritages.Heritage.HeritageModel
import org.junit.Test

import org.junit.Assert.*

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
class ExampleUnitTest {

    @Test
    fun parseStringToModel() {
        var jsonString : String? = "[{ \"id\": \"1469\", \"year\": 2015, \"target\": \"DNK\",\"name\": \"The par force hunting landscape in North Zealand\",\"type\": \"Cultural\",\"region\": \"EUR\",\"regionLong\": \"Europe and North America\",\"coordinates\": \"N55 54 49 E12 21 28\",\"lat\": 55.91361111111111,\"lng\": 12.357777777777777,\"page\": \"http://whc.unesco.org/en/list/1469\",\"image\": \"http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg\",\"imageAuthor\": \"The par force hunting landscape in North Zealand © Ib Welling \",\"shortInfo\": \"The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. \",\"longInfo\": null }]"
        val heritageModel = HeritageModel(1469,2015,"DNK", "Cultural"
            ,"The par force hunting landscape in North Zealand"
            , "EUR", "Europe and North America", "N55 54 49 E12 21 28"
            , 55.91361111111111, 12.357777777777777, "http://whc.unesco.org/en/list/1469"
            , "http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg"
            , "The par force hunting landscape in North Zealand © Ib Welling "
            , "The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. "
            , null)
        assertEquals(heritageModel.id, Utils.parseStringToModel(jsonString)!![0].id)
        assertEquals(heritageModel.year, Utils.parseStringToModel(jsonString)!![0].year)
        assertEquals(heritageModel.target, Utils.parseStringToModel(jsonString)!![0].target)
        assertEquals(heritageModel.name, Utils.parseStringToModel(jsonString)!![0].name)
        assertEquals(heritageModel.type, Utils.parseStringToModel(jsonString)!![0].type)
        assertEquals(heritageModel.region, Utils.parseStringToModel(jsonString)!![0].region)
        assertEquals(heritageModel.regionLong, Utils.parseStringToModel(jsonString)!![0].regionLong)
        assertEquals(heritageModel.coordinates, Utils.parseStringToModel(jsonString)!![0].coordinates)
        assertEquals(heritageModel.latitude, Utils.parseStringToModel(jsonString)!![0].latitude)
        assertEquals(heritageModel.longitude, Utils.parseStringToModel(jsonString)!![0].longitude)
        assertEquals(heritageModel.pageString, Utils.parseStringToModel(jsonString)!![0].pageString)
        assertEquals(heritageModel.imageString, Utils.parseStringToModel(jsonString)!![0].imageString)
        assertEquals(heritageModel.imageAuthor, Utils.parseStringToModel(jsonString)!![0].imageAuthor)
        assertEquals(heritageModel.shortInfo, Utils.parseStringToModel(jsonString)!![0].shortInfo)
        assertEquals(heritageModel.longInfo, Utils.parseStringToModel(jsonString)!![0].longInfo)

        jsonString = ""
        assertEquals(null, Utils.parseStringToModel(jsonString))

        jsonString = null
        assertEquals(null, Utils.parseStringToModel(jsonString))
    }

    @Test
    fun isLatLngValid() {


        var heritageModel = HeritageModel(1469,2015,"DNK", "Cultural"
            ,"The par force hunting landscape in North Zealand"
            , "EUR", "Europe and North America", "N55 54 49 E12 21 28"
            , 55.91361111111111, null, "http://whc.unesco.org/en/list/1469"
            , "http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg"
            , "The par force hunting landscape in North Zealand © Ib Welling "
            , "The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. "
            , null)

        assertEquals(false, heritageModel.isLatLngValid())

        heritageModel = HeritageModel(1469,2015,"DNK", "Cultural"
            ,"The par force hunting landscape in North Zealand"
            , "EUR", "Europe and North America", "N55 54 49 E12 21 28"
            , null, null, "http://whc.unesco.org/en/list/1469"
            , "http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg"
            , "The par force hunting landscape in North Zealand © Ib Welling "
            , "The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. "
            , null)

        assertEquals(false, heritageModel.isLatLngValid())

        heritageModel = HeritageModel(1469,2015,"DNK", "Cultural"
            ,"The par force hunting landscape in North Zealand"
            , "EUR", "Europe and North America", "N55 54 49 E12 21 28"
            , 0.0, null, "http://whc.unesco.org/en/list/1469"
            , "http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg"
            , "The par force hunting landscape in North Zealand © Ib Welling "
            , "The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. "
            , null)

        assertEquals(false, heritageModel.isLatLngValid())

        heritageModel = HeritageModel(1469,2015,"DNK", "Cultural"
            ,"The par force hunting landscape in North Zealand"
            , "EUR", "Europe and North America", "N55 54 49 E12 21 28"
            , 55.91361111111111, 12.357777777777777, "http://whc.unesco.org/en/list/1469"
            , "http://whc.unesco.org//uploads/thumbs/site_1469_0005-750-0-20150610114233.jpg"
            , "The par force hunting landscape in North Zealand © Ib Welling "
            , "The par force hunting landscape in North Zealand\n\nLocated about 30 km northeast of Copenhagen, this cultural landscape encompasses the two hunting forests of Store Dyrehave and Gribskov, as well as the hunting park of Jægersborg Hegn/Jægersborg Dyrehave. This is a designed landscape where Danish kings and their court exercised par forcehunting, or hunting with hounds, which reached its peak from the Middle Ages to the end of the 16th century. With hunting lanes laid out in an orthogonal grid pattern, their numbered stone posts, enclosures and hunting lodges, the site demonstrates the application of Baroque landscaping principles to forested areas. "
            , null)
        assertEquals(true, heritageModel.isLatLngValid())
    }
}
