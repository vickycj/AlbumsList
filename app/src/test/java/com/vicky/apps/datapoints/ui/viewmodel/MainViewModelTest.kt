package com.vicky.apps.datapoints.ui.viewmodel


import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.vicky.apps.datapoints.common.SchedulerProvider
import com.vicky.apps.datapoints.data.remote.Repository
import com.vicky.apps.datapoints.data.room.entity.Albums

import io.reactivex.Single
import io.reactivex.observers.TestObserver
import io.reactivex.schedulers.Schedulers
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.runner.RunWith
import org.mockito.Mock
import org.mockito.Mockito
import org.mockito.MockitoAnnotations
import org.mockito.junit.MockitoJUnitRunner

@RunWith(MockitoJUnitRunner::class)
class MainViewModelTest {


    @Mock
    lateinit var repository: Repository

    private val schedulerProvider = SchedulerProvider(Schedulers.trampoline(), Schedulers.trampoline())

    private lateinit var viewModel: MainViewModel

    @Before
    fun setUp() {
        MockitoAnnotations.initMocks(this)
        viewModel = MainViewModel(repository, schedulerProvider)
    }

    @After
    fun tearDown() {
    }



    @Test
    fun getDataFromRemote() {

        Mockito.`when`(repository.getDataFromApi()).thenReturn(Single.just(getObject()))

        val testObserver = TestObserver<List<Albums>>()

        viewModel.generateApiCall()
            .subscribe(testObserver)

        testObserver.assertNoErrors()
        testObserver.assertValue { responseData -> responseData.size == 100 }
    }



    fun getObject(): List<Albums>{
        val token = object : TypeToken<List<Albums>>() {

        }
        val jsonData = "[\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 1,\n" +
                "    \"title\": \"quidem molestiae enim\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 2,\n" +
                "    \"title\": \"sunt qui excepturi placeat culpa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 3,\n" +
                "    \"title\": \"omnis laborum odio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 4,\n" +
                "    \"title\": \"non esse culpa molestiae omnis sed optio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 5,\n" +
                "    \"title\": \"eaque aut omnis a\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 6,\n" +
                "    \"title\": \"natus impedit quibusdam illo est\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 7,\n" +
                "    \"title\": \"quibusdam autem aliquid et et quia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 8,\n" +
                "    \"title\": \"qui fuga est a eum\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 9,\n" +
                "    \"title\": \"saepe unde necessitatibus rem\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 1,\n" +
                "    \"id\": 10,\n" +
                "    \"title\": \"distinctio laborum qui\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 11,\n" +
                "    \"title\": \"quam nostrum impedit mollitia quod et dolor\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 12,\n" +
                "    \"title\": \"consequatur autem doloribus natus consectetur\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 13,\n" +
                "    \"title\": \"ab rerum non rerum consequatur ut ea unde\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 14,\n" +
                "    \"title\": \"ducimus molestias eos animi atque nihil\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 15,\n" +
                "    \"title\": \"ut pariatur rerum ipsum natus repellendus praesentium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 16,\n" +
                "    \"title\": \"voluptatem aut maxime inventore autem magnam atque repellat\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 17,\n" +
                "    \"title\": \"aut minima voluptatem ut velit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 18,\n" +
                "    \"title\": \"nesciunt quia et doloremque\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 19,\n" +
                "    \"title\": \"velit pariatur quaerat similique libero omnis quia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 2,\n" +
                "    \"id\": 20,\n" +
                "    \"title\": \"voluptas rerum iure ut enim\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 21,\n" +
                "    \"title\": \"repudiandae voluptatem optio est consequatur rem in temporibus et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 22,\n" +
                "    \"title\": \"et rem non provident vel ut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 23,\n" +
                "    \"title\": \"incidunt quisquam hic adipisci sequi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 24,\n" +
                "    \"title\": \"dolores ut et facere placeat\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 25,\n" +
                "    \"title\": \"vero maxime id possimus sunt neque et consequatur\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 26,\n" +
                "    \"title\": \"quibusdam saepe ipsa vel harum\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 27,\n" +
                "    \"title\": \"id non nostrum expedita\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 28,\n" +
                "    \"title\": \"omnis neque exercitationem sed dolor atque maxime aut cum\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 29,\n" +
                "    \"title\": \"inventore ut quasi magnam itaque est fugit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 3,\n" +
                "    \"id\": 30,\n" +
                "    \"title\": \"tempora assumenda et similique odit distinctio error\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 31,\n" +
                "    \"title\": \"adipisci laborum fuga laboriosam\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 32,\n" +
                "    \"title\": \"reiciendis dolores a ut qui debitis non quo labore\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 33,\n" +
                "    \"title\": \"iste eos nostrum\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 34,\n" +
                "    \"title\": \"cumque voluptatibus rerum architecto blanditiis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 35,\n" +
                "    \"title\": \"et impedit nisi quae magni necessitatibus sed aut pariatur\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 36,\n" +
                "    \"title\": \"nihil cupiditate voluptate neque\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 37,\n" +
                "    \"title\": \"est placeat dicta ut nisi rerum iste\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 38,\n" +
                "    \"title\": \"unde a sequi id\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 39,\n" +
                "    \"title\": \"ratione porro illum labore eum aperiam sed\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 4,\n" +
                "    \"id\": 40,\n" +
                "    \"title\": \"voluptas neque et sint aut quo odit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 41,\n" +
                "    \"title\": \"ea voluptates maiores eos accusantium officiis tempore mollitia consequatur\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 42,\n" +
                "    \"title\": \"tenetur explicabo ea\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 43,\n" +
                "    \"title\": \"aperiam doloremque nihil\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 44,\n" +
                "    \"title\": \"sapiente cum numquam officia consequatur vel natus quos suscipit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 45,\n" +
                "    \"title\": \"tenetur quos ea unde est enim corrupti qui\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 46,\n" +
                "    \"title\": \"molestiae voluptate non\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 47,\n" +
                "    \"title\": \"temporibus molestiae aut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 48,\n" +
                "    \"title\": \"modi consequatur culpa aut quam soluta alias perspiciatis laudantium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 49,\n" +
                "    \"title\": \"ut aut vero repudiandae voluptas ullam voluptas at consequatur\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 5,\n" +
                "    \"id\": 50,\n" +
                "    \"title\": \"sed qui sed quas sit ducimus dolor\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 51,\n" +
                "    \"title\": \"odit laboriosam sint quia cupiditate animi quis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 52,\n" +
                "    \"title\": \"necessitatibus quas et sunt at voluptatem\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 53,\n" +
                "    \"title\": \"est vel sequi voluptatem nemo quam molestiae modi enim\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 54,\n" +
                "    \"title\": \"aut non illo amet perferendis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 55,\n" +
                "    \"title\": \"qui culpa itaque omnis in nesciunt architecto error\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 56,\n" +
                "    \"title\": \"omnis qui maiores tempora officiis omnis rerum sed repellat\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 57,\n" +
                "    \"title\": \"libero excepturi voluptatem est architecto quae voluptatum officia tempora\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 58,\n" +
                "    \"title\": \"nulla illo consequatur aspernatur veritatis aut error delectus et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 59,\n" +
                "    \"title\": \"eligendi similique provident nihil\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 6,\n" +
                "    \"id\": 60,\n" +
                "    \"title\": \"omnis mollitia sunt aliquid eum consequatur fugit minus laudantium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 61,\n" +
                "    \"title\": \"delectus iusto et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 62,\n" +
                "    \"title\": \"eos ea non recusandae iste ut quasi\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 63,\n" +
                "    \"title\": \"velit est quam\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 64,\n" +
                "    \"title\": \"autem voluptatem amet iure quae\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 65,\n" +
                "    \"title\": \"voluptates delectus iure iste qui\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 66,\n" +
                "    \"title\": \"velit sed quia dolor dolores delectus\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 67,\n" +
                "    \"title\": \"ad voluptas nostrum et nihil\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 68,\n" +
                "    \"title\": \"qui quasi nihil aut voluptatum sit dolore minima\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 69,\n" +
                "    \"title\": \"qui aut est\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 7,\n" +
                "    \"id\": 70,\n" +
                "    \"title\": \"et deleniti unde\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 71,\n" +
                "    \"title\": \"et vel corporis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 72,\n" +
                "    \"title\": \"unde exercitationem ut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 73,\n" +
                "    \"title\": \"quos omnis officia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 74,\n" +
                "    \"title\": \"quia est eius vitae dolor\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 75,\n" +
                "    \"title\": \"aut quia expedita non\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 76,\n" +
                "    \"title\": \"dolorem magnam facere itaque ut reprehenderit tenetur corrupti\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 77,\n" +
                "    \"title\": \"cupiditate sapiente maiores iusto ducimus cum excepturi veritatis quia\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 78,\n" +
                "    \"title\": \"est minima eius possimus ea ratione velit et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 79,\n" +
                "    \"title\": \"ipsa quae voluptas natus ut suscipit soluta quia quidem\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 8,\n" +
                "    \"id\": 80,\n" +
                "    \"title\": \"id nihil reprehenderit\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 81,\n" +
                "    \"title\": \"quibusdam sapiente et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 82,\n" +
                "    \"title\": \"recusandae consequatur vel amet unde\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 83,\n" +
                "    \"title\": \"aperiam odio fugiat\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 84,\n" +
                "    \"title\": \"est et at eos expedita\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 85,\n" +
                "    \"title\": \"qui voluptatem consequatur aut ab quis temporibus praesentium\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 86,\n" +
                "    \"title\": \"eligendi mollitia alias aspernatur vel ut iusto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 87,\n" +
                "    \"title\": \"aut aut architecto\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 88,\n" +
                "    \"title\": \"quas perspiciatis optio\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 89,\n" +
                "    \"title\": \"sit optio id voluptatem est eum et\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 9,\n" +
                "    \"id\": 90,\n" +
                "    \"title\": \"est vel dignissimos\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 91,\n" +
                "    \"title\": \"repellendus praesentium debitis officiis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 92,\n" +
                "    \"title\": \"incidunt et et eligendi assumenda soluta quia recusandae\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 93,\n" +
                "    \"title\": \"nisi qui dolores perspiciatis\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 94,\n" +
                "    \"title\": \"quisquam a dolores et earum vitae\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 95,\n" +
                "    \"title\": \"consectetur vel rerum qui aperiam modi eos aspernatur ipsa\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 96,\n" +
                "    \"title\": \"unde et ut molestiae est molestias voluptatem sint\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 97,\n" +
                "    \"title\": \"est quod aut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 98,\n" +
                "    \"title\": \"omnis quia possimus nesciunt deleniti assumenda sed autem\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 99,\n" +
                "    \"title\": \"consectetur ut id impedit dolores sit ad ex aut\"\n" +
                "  },\n" +
                "  {\n" +
                "    \"userId\": 10,\n" +
                "    \"id\": 100,\n" +
                "    \"title\": \"enim repellat iste\"\n" +
                "  }\n" +
                "]"
        val gson = Gson()
        return gson.fromJson(jsonData,token.type)

    }



}