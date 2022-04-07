<?php

use Illuminate\Http\Request;
use Illuminate\Support\Facades\Route;
use App\Http\Controllers\RentController;
use App\Http\Controllers\RenterController;
use App\Http\Controllers\CarController;
use App\Http\Controllers\AuthController;
use App\Http\Controllers\BrandController;
use App\Http\Controllers\ColorController;
use App\Http\Controllers\GearboxController;
use App\Http\Controllers\PropulsionController;

/*
|--------------------------------------------------------------------------
| API Routes
|--------------------------------------------------------------------------
|
| Here is where you can register API routes for your application. These
| routes are loaded by the RouteServiceProvider within a group which
| is assigned the "api" middleware group. Enjoy building your API!
|
*/
Route::group(["middleware" => ["auth:sanctum"]], function () {
    Route::post('/logout', [AuthController::class, "logout"]);

    Route::post('/brands', [BrandController::class, 'store']);
    Route::put('/brands/{id}', [BrandController::class, 'update']);
    Route::delete('/brands/{id}', [BrandController::class, 'delete']);

    Route::post('/colors', [ColorController::class, 'store']);
    Route::put('/colors/{id}', [ColorController::class, 'update']);
    Route::delete('/colors/{id}', [ColorController::class, 'delete']);

    Route::post('/cars', [CarController::class, 'create']);
    Route::put('/cars/{id}', [CarController::class, 'update']);
    Route::delete('/cars/{id}', [CarController::class, 'delete']);

    Route::post('/rents', [RentController::class, 'create']);
    Route::put('/rents/{id}', [RentController::class, 'update']);
    Route::delete('/rents/{id}', [RentController::class, 'delete']);

    Route::post('/renters', [RenterController::class, 'create']);
    Route::put('/renters/{id}', [RenterController::class, 'update']);
    Route::delete('/renters/{id}', [RenterController::class, 'delete']);
});
Route::post('/login', [AuthController::class, "login"]);
Route::post('/register', [AuthController::class, "register"]);

Route::get('/cars', [CarController::class, 'index']);
Route::get('/cars/{id}', [CarController::class, 'show']);

Route::get('/rents', [RentController::class, 'index']);
Route::get('/rents/{id}', [RentController::class, 'show']);

Route::get('/renters', [RenterController::class, 'index']);
Route::get('/renters/{id}', [RenterController::class, 'show']);

Route::get('/brands', [BrandController::class, 'index']);
Route::get('/brands/{id}', [BrandController::class, 'show']);

Route::get('/colors', [ColorController::class, 'index']);
Route::get('/colors/{id}', [ColorController::class, 'show']);

Route::get('/gearboxes', [GearboxController::class, 'index']);
Route::get('/gearboxes{id}', [GearboxController::class, 'show']);

Route::get('/propulsions', [PropulsionController::class, 'index']);
Route::get('/propulsions/{id}', [PropulsionController::class, 'show']);

