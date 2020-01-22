package com.home.mvvmandroiddemo.viewmodel.domain

import com.home.mvvmandroiddemo.common.rxusecases.usecases.CompletableUseCase
import com.home.mvvmandroiddemo.model.data.model.DataModel
import com.home.mvvmandroiddemo.model.data.store.DataStore
import io.reactivex.Completable
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class GetDataUseCase @Inject constructor(
    private val dataStore: DataStore
) : CompletableUseCase<Unit>() {

    override fun prepare(args: Unit): Completable {
        return Completable.timer(3, TimeUnit.SECONDS).andThen(
            Completable.fromCallable { dataStore.setData(getData()) }
        )
    }

    private fun getData(): MutableList<DataModel> {
        val fakeData = mutableListOf<DataModel>()
        fakeData.add(
            DataModel(
                "JavaScript",
                "JavaScript（通常縮寫為JS）是一種進階的、直譯的程式語言[5]。JavaScript是一門基於原型、函式先行的語言[6]，是一門多範式的語言，它支援物件導向編程，指令式程式設計，以及函式語言程式設計。它提供語法來操控文字、陣列、日期以及正規表示式等，不支援I/O，比如網路、儲存和圖形等，但這些都可以由它的宿主環境提供支援。它已經由ECMA（歐洲電腦製造商協會）透過ECMAScript實作語言的標準化[5]。它被世界上的絕大多數網站所使用，也被世界主流瀏覽器（Chrome、IE、Firefox、Safari、Opera）支援。"
            )
        )
        fakeData.add(
            DataModel(
                "Python",
                "Python（英國發音：/ˈpaɪθən/ 美國發音：/ˈpaɪθɑːn/）是一種廣泛使用的直譯式、進階程式、通用型程式語言，由吉多·范羅蘇姆創造，第一版釋出於1991年。可以視之為一種改良（加入一些其他程式語言的優點，如物件導向）的LISP。[來源請求]Python的設計哲學強調代碼的可讀性和簡潔的語法（尤其是使用空格縮排劃分代碼塊，而非使用大括號或者關鍵詞）。相比於C++或Java，Python讓開發者能夠用更少的代碼表達想法。不管是小型還是大型程式，該語言都試圖讓程式的結構清晰明了。"
            )
        )
        fakeData.add(
            DataModel(
                "Java",
                "Java程式語言的風格十分接近C++語言。繼承了C++語言物件導向技術的核心，捨棄了容易引起錯誤的指標，以參照取代；移除了C++中的運算子多载和多重繼承特性，用介面取代；增加垃圾回收器功能。在Java SE 1.5版本中引入了泛型程式設計、類型安全的列舉、不定長參數和自動裝/拆箱特性。昇陽電腦對Java語言的解釋是：「Java程式語言是個簡單、物件導向、分散式、解釋性、健壯、安全與系統無關、可移植、高效能、多執行緒和動態的語言」"
            )
        )
        fakeData.add(
            DataModel(
                "PHP",
                "PHP（全稱：PHP：Hypertext Preprocessor，即「PHP：超文字預處理器」）是一種開源的通用電腦手稿語言，尤其適用於網路開發並可嵌入HTML中使用。PHP的語法借鑑吸收C語言、Java和Perl等流行電腦語言的特點，易於一般程式設計師學習。PHP的主要目標是允許網路開發人員快速編寫動態頁面，但PHP也被用於其他很多領域。[1]\n" +
                        "\n" +
                        "PHP最初是由勒多夫在1995年開始開發的；現在PHP的標準由the PHP Group[2]維護。PHP以PHP License作為許可協定，不過因為這個協定限制了PHP名稱的使用，所以和開放原始碼許可協定GPL不相容。"
            )
        )
        fakeData.add(
            DataModel(
                "C#",
                "C#是微軟推出的一種基於.NET框架的、物件導向的進階程式語言。C#以.NET框架類別館作為基礎，擁有類似Visual Basic的快速開發能力。C#由安德斯·海爾斯伯格主持開發，微軟在2000年發布了這種語言，希望藉助這種語言來取代Java。C#已經成為Ecma國際和國際標準組織的標準規範。"
            )
        )
        return fakeData
    }
}
