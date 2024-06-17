package com.example.sunflower

import android.util.Log
import com.example.sunflower.retrofitTest.Constants
import com.example.sunflower.retrofitTest.RESPONSE_STATE
import com.example.sunflower.retrofitTest.RetrofitManager
import kotlinx.coroutines.DelicateCoroutinesApi
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

//앱 실행시 처음에만 동작하기 위해서
class PlastListRepository {
    var plantList = ArrayList<PlantList>()

    //db에 데이터 insert 하기
    @OptIn(DelicateCoroutinesApi::class)
    fun firstInsert(dbHelper: DBHelperFisrt) {
        val database = dbHelper.writableDatabase

        this.plantList = arrayListOf(
            PlantList(
                null,
                "apple",
                "사과(沙果)는 사과나무의 열매로, 세계적으로 널리 재배되는 열매 가운데 하나다. 평과(苹果), 빈파(頻婆)라고도 한다. 성인 기준 권고안을 사용한 추정치임. 사과 열매는 가을에 익는데, 보통 지름이 5~9센티미터다"
            ),
            PlantList(
                null,
                "banana",
                "바나나는 주로 식용을 목적으로 재배되어, 간식으로 이용되거나 가공 곡식, 과일 칵테일, 샐러드, 케이크, 파이 등에 재료로 쓰인다. 이 과일에는 탄수화물이 풍부하고, 인, 칼륨, 비타민A, 비타민C가 들어 있다. 뿐만 아니라 수용성 식이섬유가 풍부하여 변비 예방 및 개선에 도움을 준다"
            ),
            PlantList(
                null,
                "grape",
                "포도(葡萄, grape)는 포도속(Vitis) 식물의 총칭, 또는 그 열매를 말한다. 포도의 품종에는 포도(V. vinifera)·미국포도(V. labrusca)·교배종이 있다"
            ),
            PlantList(
                null,
                "pear",
                "배는 인간이나 동물의 몸통 앞 부분을 나타낸다. 배(裵)는 한국의 성씨이다. 배(胚)는 다세포 진핵생물의 초기 발생 과정이다. 배(belly)는 의학에서 힘살(근복)을 의미한다"
            ),
            PlantList(
                null,
                "pineapple",
                "오렌지(영어: orange 오린지)는 비타민 C가 매우 풍부한 과일의 하나로, 일반적으로 당귤나무의 열매인 당귤을 부르는 말이다"
            ),
            PlantList(
                null,
                "kiwi",
                "복숭아(영어: Prunus persica, peach)는 장미과 벚나무속에 속하는 복사나무의 열매이다. 원산지는 중국 화북의 산시성과 간쑤성의 해발 600 ~ 2,000m 고원 지대이다. 복사나무는 복숭아나무라고도 부르며, 갈잎 작은키 나무다"
            ),
            PlantList(
                null,
                "strawberry",
                "딸기(영어: strawberry 또는 garden strawberry, 학명: Fragaria × ananassa)는 장미과 딸기속에 속하는 과채류이다. 산딸기, 뱀딸기, 야생딸기 등과 재배하는 딸기로 구분된다. 꽃말은 애정, 우애, 우정, 존중 등이다"
            ),
            PlantList(
                null,
                "watermelon",
                "수박은 이뇨·지갈(止渴)·해서(解暑)의 작용이 있어 방광염·수종·신장염·고혈압·서열번갈 등 질병을 예방하는데 효과적인 것으로 알려져 있다. 수박의 열매는 거의 대부분이 수분 92%이고 탄수화물이 8% 함유되어 있어서 여름철에 잘 어울리는 채소다"
            )
        )

        GlobalScope.launch(Dispatchers.Default) {
            Log.d(Constants.TAG, "사이즈값 확인 : ${plantList.size}")

            for (i: Int in 0..plantList.size - 1) {
                RetrofitManager.instance.searchPhotos(
                    plantList.get(i).fruitName,
                    completion = { responseState, responseDataArrayList ->
                        when (responseState) {
                            RESPONSE_STATE.OKAY -> {
                                Log.d(Constants.TAG, "api 호출 성공 : ${responseDataArrayList?.size}")
                            }

                            RESPONSE_STATE.FAIL -> {
                                Log.d(Constants.TAG, "api 호출 실패 : $responseDataArrayList")
                            }
                        }

                        if (responseDataArrayList != null) {
                            plantList.get(i).fruitImage = responseDataArrayList.get(i).thumbnail
                            plantList.get(i).fruitImage?.let {
                                dbHelper.insert(
                                    database,
                                    plantList.get(i).fruitName,
                                    plantList.get(i).fruitContent,
                                    it
                                )
                            }
                        }
                    })
            }
        }
    }
}