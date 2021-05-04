package com.dev.darkmodeapp

class test {


    fun inputMyArrayIntData(data : ArrayList<Int>, variance : Int) {
        var filteredData : MutableList<MutableList<Int>> = mutableListOf()

        for (index in data.indices) {
            if (data.size == 1) {
                filteredData.add(data)
            } else {
                if (index == 0) {
                    filteredData.add(mutableListOf(data[index]))
                } else {
                    val diff = data[index] - data[index - 1]
                    if (diff <= variance) {
                        if (filteredData.isEmpty()) {
                            filteredData.add(mutableListOf(data[index]))
                        } else {
                            filteredData.last().add(data[index])
                        }
                    } else {
                        filteredData.add(mutableListOf())
                    }
                }
            }
//        filteredData.add(mutableListOf())
//        println("item at $index is ${items[index]}")
        }
       =
        getBiggestArray(filteredData)
    }

    fun getBiggestArray(filteredData : MutableList<MutableList<Int>>) {
        filteredData.sortedBy {
            it.size
        }

        val finalList = filteredData.first()
        println(finalList)

//    var myData : MutableList<Int> = mutableListOf()
//    filteredData.forEach {
//        myData.add(it.size)
//    }
//    myData.sort()
//    val index = myData.first()
//    println(filteredData[index])
    }
}