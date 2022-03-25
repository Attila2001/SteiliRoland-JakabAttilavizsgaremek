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
        Schema::create('cars', function (Blueprint $table) {
            $table->engine = "InnoDb";
            $table->charset = "utf8mb4";
            $table->collation = "utf8mb4_hungarian_ci";
            $table->increments('id');
            $table->string( "platenumber" );
            $table->integer("doornumber");
            $table->integer("modelyear");
            $table->integer('propulsion_id')->unsigned();
            $table->foreign('propulsion_id')->references('id')->on('propulsions');
            $table->integer('gearbox_id')->unsigned();
            $table->foreign('gearbox_id')->references('id')->on('gearboxes');
            $table->integer('brand_id')->unsigned();
            $table->foreign('brand_id')->references('id')->on('brands');
            $table->integer('color_id')->unsigned();
            $table->foreign('color_id')->references('id')->on('colors');
        });
        
        DB::table('cars')->insert(
            [
                [
                    'platenumber' => 'asd123',
                    'doornumber' => '5',
                    'modelyear' => '2008',          
                    'propulsion_id' => '2',
                    'gearbox_id' => '2',
                    'brand_id' => '2',
                    'color_id' => '2',
                ],
                [
                    'platenumber' => 'asd123',
                    'doornumber' => '3',
                    'modelyear' => '2006',          
                    'propulsion_id' => '1',
                    'gearbox_id' => '1',
                    'brand_id' => '1',
                    'color_id' => '1',
                ],
                [
                    'platenumber' => 'asd123',
                    'doornumber' => '5',
                    'modelyear' => '2012',          
                    'propulsion_id' => '3',
                    'gearbox_id' => '2',
                    'brand_id' => '3',
                    'color_id' => '3',
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
        Schema::dropIfExists('cars');
    }
};
