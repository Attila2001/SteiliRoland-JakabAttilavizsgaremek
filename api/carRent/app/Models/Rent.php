<?php

namespace App\Models;

use Illuminate\Database\Eloquent\Factories\HasFactory;
use Illuminate\Database\Eloquent\Model;

class Rent extends Model
{
    use HasFactory;
    protected $fillable =[
        "startdate",
        "enddate",
        "deposit",
        "renter_id",
        "car_id"
    ];
    public $timestamp = false;
}
