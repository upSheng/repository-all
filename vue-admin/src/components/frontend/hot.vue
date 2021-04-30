<template>
    <div class="hot">



            <swiper style="width: 100%"
                    :slides-per-view="1"
                    :space-between="50"
                    navigation
                    :pagination="{ clickable: true }"
                    :scrollbar="{ draggable: true }"
                    @swiper="onSwiper"
                    @slideChange="onSlideChange"
            >
                <swiper-slide>


                        <video  autoplay="autoplay" loop="loop" muted="muted"

                                :src="src">

                        </video>


                </swiper-slide>
                <swiper-slide>
                    <video  autoplay="autoplay" loop="loop" muted="muted"

                            :src="src">

                    </video>
                </swiper-slide>
                <swiper-slide>
                    <video  autoplay="autoplay" loop="loop" muted="muted"

                            :src="src">

                    </video>
                </swiper-slide>

            </swiper>




    </div>
</template>

<script>

    import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper';


    import { Swiper, SwiperSlide } from 'swiper/vue';


    import 'swiper/swiper.scss';
    import 'swiper/components/navigation/navigation.scss';
    import 'swiper/components/pagination/pagination.scss';
    import 'swiper/components/scrollbar/scrollbar.scss';

    // install Swiper modules
    SwiperCore.use([Navigation, Pagination, Scrollbar, A11y]);


    export default {
        name: 'hot',
        data() {
            return {
                orderAwardList: [],
                src:"https://media.st.dl.pinyuncloud.com/steam/apps/256746284/movie480.webm?t=1553549450"
            };
        },
        components: {
            Swiper,
            SwiperSlide,
        },
        methods: {
            onSwiper(swiper) {
                console.log(swiper);
            },
            onSlideChange() {
                console.log('slide change');
            },
        },
        mounted() {

        }
    }
</script>
<style scoped>

    .hot {

        height: 600px;
    }

    video {
        width: 100%;  object-fit: cover;
    }







</style>