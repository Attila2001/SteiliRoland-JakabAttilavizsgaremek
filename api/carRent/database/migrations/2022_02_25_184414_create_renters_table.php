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
        Schema::create('renters', function (Blueprint $table) {
            $table->engine = "InnoDb";
            $table->charset = "utf8mb4";
            $table->collation = "utf8mb4_hungarian_ci";
            $table->increments('id');
            $table->string( "name" );
            $table->string( "email" );
            $table->string( "phone" );
            $table->string( "address" );
            $table->string( "identify" );
        });
        DB::table('renters')->insert(
            [
                [
                    'name' => 'Kazimour Gábor',
                    'email' => 'kazimour@gabor.com',
                    'phone' => '0123456789',
                    'address' =>' Budapest, Szállás u.5 ',
                    'identify' => '987654321',
                ],
                [
                    'name' => 'Sylvestor Zoltán',
                    'email' => 'sylvestor@zoltan.com',
                    'phone' => '0123456789',
                    'address' =>'Budapest,Tavasz u.112',
                    'identify' => '987654321',
                ],
                [
                    'name' => 'Moody Lajos',
                    'email' => 'moody@lajos.com',
                    'phone' => '0123456789',
                    'address' =>'Budapest, Erdős u.1',
                    'identify' => '987654321',
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
        Schema::dropIfExists('renters');
    }
};
