<?php

use Illuminate\Database\Migrations\Migration;
use Illuminate\Database\Schema\Blueprint;
use Illuminate\Support\Facades\Schema;

return new class extends Migration
{
    /**
     * Run the migrations.
     *
     * @return void
     */
    public function up()
    {
        Schema::create('rents', function (Blueprint $table) {
            $table->engine = "InnoDb";
            $table->charset = "utf8mb4";
            $table->collation = "utf8mb4_hungarian_ci";
            $table->increments('id');
            $table->date('startdate');
            $table->date('enddate');
            $table->integer('deposit');
            $table->integer('renter_id')->unsigned();
            $table->foreign('renter_id')->references('id')->on('renters');
            $table->integer('car_id')->unsigned();
            $table->foreign('car_id')->references('id')->on('cars');
        });
        DB::table('rents')->insert(
            [
                [
                    'startdate' => '2022-01-31',
                    'enddate' => '2022-02-7',
                    'deposit' => '20000',
                    'renter_id' =>'1',
                    'car_id' => '1',
                ],
                [
                    'startdate' => '2022-02-03',
                    'enddate' => '2022-02-13',
                    'deposit' => '25000',
                    'renter_id' =>'2',
                    'car_id' => '2',  
                ],
                [
                    'startdate' => '2022-02-15',
                    'enddate' => '2022-02-28',
                    'deposit' => '30000',
                    'renter_id' =>'3',
                    'car_id' => '3',
                ]
            ]
            

        );
        
    }

    /**
     * Reverse the migrations.
     *
     * @return void
     */
    public function down()
    {
        Schema::dropIfExists('rents');
    }
};
