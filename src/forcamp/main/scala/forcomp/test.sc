package forcomp

object test {

   //val handledDictionary = Anagrams.dictionaryByOccurrences withDefaultValue List()
   val sentence = List("Linux", "rulez")          //> sentence  : List[String] = List(Linux, rulez)
   Anagrams.sentenceAnagrams(sentence)            //> res0: List[forcomp.Anagrams.Sentence] = List(List(rulez, Linux), List(Zulu, 
                                                  //| Rex, Lin), List(Zulu, Rex, nil), List(Zulu, Lin, Rex), List(Zulu, nil, Rex),
                                                  //|  List(Uzi, Rex, null), List(Uzi, null, Rex), List(Linux, rulez), List(Rex, Z
                                                  //| ulu, Lin), List(Rex, Zulu, nil), List(Rex, Uzi, null), List(Rex, null, Uzi),
                                                  //|  List(Rex, Lin, Zulu), List(Rex, nil, Zulu), List(null, Uzi, Rex), List(null
                                                  //| , Rex, Uzi), List(Lin, Zulu, Rex), List(Lin, Rex, Zulu), List(nil, Zulu, Rex
                                                  //| ), List(nil, Rex, Zulu))
                                                  
   
   
   //val testComb = Anagrams.combinations(Anagrams.sentenceOccurrences(sentence))
   
   //val testFilter = testComb.filter(occurrence => handledDictionary(occurrence).length > 0)
   
   //for(eachTest <- testFilter) yield handledDictionary(eachTest)
}