//package com.example.sunflower
//
//
//import android.util.Log
//import androidx.lifecycle.LiveData
//import androidx.lifecycle.MutableLiveData
//import androidx.lifecycle.ViewModel
//import androidx.recyclerview.widget.GridLayoutManager
//import com.example.sunflower.Adapter.PlantListAdapter
//import com.example.sunflower.PlantList
//import com.example.sunflower.retrofitTest.Constants
//import com.example.sunflower.retrofitTest.RESPONSE_STATE
//import com.example.sunflower.retrofitTest.RetrofitManager
//import kotlinx.coroutines.Dispatchers
//import kotlinx.coroutines.GlobalScope
//import kotlinx.coroutines.launch
//
//
//class DataViewModel : ViewModel() {
//    private var _state = MutableLiveData<PlantList>()
//    val state: LiveData<PlantList> get() = _state
//
//    fun addPlant() {
//        this._state.apply {
//            PlantList(
//                null,
//                "apple",
//                "사과(沙果)는 사과나무의 열매로, 세계적으로 널리 재배되는 열매 가운데 하나다. 평과(苹果), 빈파(頻婆)라고도 한다. 성인 기준 권고안을 사용한 추정치임. 사과 열매는 가을에 익는데, 보통 지름이 5~9센티미터다"
//            )
//            PlantList(
//                null,
//                "banana",
//                "바나나는 주로 식용을 목적으로 재배되어, 간식으로 이용되거나 가공 곡식, 과일 칵테일, 샐러드, 케이크, 파이 등에 재료로 쓰인다. 이 과일에는 탄수화물이 풍부하고, 인, 칼륨, 비타민A, 비타민C가 들어 있다. 뿐만 아니라 수용성 식이섬유가 풍부하여 변비 예방 및 개선에 도움을 준다"
//            )
//            PlantList(
//                null,
//                "grape",
//                "포도(葡萄, grape)는 포도속(Vitis) 식물의 총칭, 또는 그 열매를 말한다. 포도의 품종에는 포도(V. vinifera)·미국포도(V. labrusca)·교배종이 있다"
//            )
//            PlantList(
//                null,
//                "pear",
//                "배는 인간이나 동물의 몸통 앞 부분을 나타낸다. 배(裵)는 한국의 성씨이다. 배(胚)는 다세포 진핵생물의 초기 발생 과정이다. 배(belly)는 의학에서 힘살(근복)을 의미한다"
//            )
//            PlantList(
//                null,
//                "pineapple",
//                "파인애플은 식민주의의 산물로 유럽인들을 매료시켰지만, Pieter de la Court (1664~ 1739 )가 라이덴 근처에서 온실 원예를 개발할 때까지 유럽에서는 성공적으로 재배되지 않았습니다 . [30] [25] 파인애플 식물은 1719년에 네덜란드에서 영국 정원사에게, 1730년에는 프랑스 정원사에게 배포되었습니다. [25] 영국에서는 최초의 파인애플이 버킹엄셔의 도니 코트 ( Dorney Court )와 거대한 \"파인애플 난로\" 에서 재배되었습니다. "
//            )
//            PlantList(
//                null,
//                "kiwi",
//                "골든 키위(Golden Kiwi) 는 1961년 12 월에 시작되어 1989년에 종료된 뉴질랜드 복권 이었습니다 . 이는 수십 년 전에 개최된 자선 예술 조합 복권을 기반으로 했습니다. [2] 골든 키위 복권의 목적 중 하나는 해외 복권에 가는 것이 아니라 뉴질랜드에 자금을 보관하는 것이었습니다. [3] Golden Kiwi는 운영 첫 해에 £1,360,000를 모금했습니다. [4] 골든 키위의 수익금은 지역 사회의 이익을 위한 자선, 자선 또는 문화적 목적으로 분배되었습니다. [5] 골든키위는 1987년 뉴질랜드 복권위원회가 설립되면서 그 직속하에 들어갔습니다. [6] 골든키위 매출은 1987년 로또 출시 이후 감소했고 , [4] 1989년 로또 도입으로 종료되었습니다. 인스턴트 키위 스크래치 카드 추첨."
//            )
//            PlantList(
//                null,
//                "strawberry",
//                "딸기(영어: strawberry 또는 garden strawberry, 학명: Fragaria × ananassa)는 장미과 딸기속에 속하는 과채류이다. 산딸기, 뱀딸기, 야생딸기 등과 재배하는 딸기로 구분된다. 꽃말은 애정, 우애, 우정, 존중 등이다"
//            )
//            PlantList(
//                null,
//                "watermelon",
//                "수박은 이뇨·지갈(止渴)·해서(解暑)의 작용이 있어 방광염·수종·신장염·고혈압·서열번갈 등 질병을 예방하는데 효과적인 것으로 알려져 있다. 수박의 열매는 거의 대부분이 수분 92%이고 탄수화물이 8% 함유되어 있어서 여름철에 잘 어울리는 채소다"
//            )
//
//            GlobalScope.launch(Dispatchers.Default) {
//                for (i: Int in 0..state - 1) {
//                    RetrofitManager.instance.searchPhotos(
//                        state.value?.fruitName?.get(i).toString(),
//                        completion = { responseState, responseDataArrayList ->
//                            when (responseState) {
//                                RESPONSE_STATE.OKAY -> {
//                                    Log.d(
//                                        Constants.TAG,
//                                        "api 호출 성공 : ${responseDataArrayList?.size}"
//                                    )
//                                }
//
//                                RESPONSE_STATE.FAIL -> {
//                                    Log.d(Constants.TAG, "api 호출 실패 : $responseDataArrayList")
//                                }
//                            }
//
//                            if (responseDataArrayList != null) {
//                            }
//                        })
//                }
//            }
//        }
//    }
//}