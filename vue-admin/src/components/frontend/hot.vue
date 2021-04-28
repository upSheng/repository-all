<template>
    <div class="hot">

        <video  autoplay="autoplay" loop="loop" muted="muted"

                :src="src">

        </video>




        <swiper
                :slides-per-view="3"
                :space-between="50"
                @swiper="onSwiper"
                @slideChange="onSlideChange"
        >
            <swiper-slide>Slide 1</swiper-slide>
            <swiper-slide>Slide 2</swiper-slide>
            <swiper-slide>Slide 3</swiper-slide>

        </swiper>





    </div>
</template>

<script>
    // import Swiper core and required modules
    import SwiperCore, { Navigation, Pagination, Scrollbar, A11y } from 'swiper';

    // Import Swiper Vue.js components
    import { Swiper, SwiperSlide } from 'swiper/vue';

    // Import Swiper styles
    import 'swiper/swiper.scss';
    import 'swiper/components/navigation/navigation.scss';
    import 'swiper/components/pagination/pagination.scss';
    import 'swiper/components/scrollbar/scrollbar.scss';

    //install Swiper modules
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
        height: 100%;
    }

    video {
        width: 100%; height: 100%; object-fit: cover;
    }

</style>